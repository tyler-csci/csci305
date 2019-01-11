
#!/usr/bin/ruby
###############################################################
#
# CSCI 305 - Ruby Programming Lab
#
# Tyler Ewald
# t.ewald95@gmail.com
#
###############################################################

$bigrams = Hash.new
$name = "Tyler Ewald"
$titleConstruct = ""
counter = 0

def cleanup_title(song)
	title = ""
	sep = /<SEP>/ #regex for getting the song title
		if song =~ sep then title = "#{$'}" #sets song after first <sep>
		end
		if title =~ sep then title = "#{$'}" #sets song after second <sep>
		end
		if title =~ sep then title = "#{$'}" #sets song after third <sep>
		end

	pre_process = /(([\(\[\{\\\/\_\-\:\"\`\+\=\*]|(feat\.)).*)/ #removes superfluous text
		if title =~ pre_process then title = "#{$`}"
		end

	punctuation = /[\?\¿\!\¡\.\;\&\@\%\#\|]/
	if title =~ punctuation then title.gsub!(punctuation, "") #removes punctuation
	end

	title.downcase! #all characters set to lowercase

	return title
end

def bigramCounts(title) #bigram counts collected by a Hash
	split = title.split

	for i in 0..split.length - 2
		$bigrams[split[i]]
		if $bigrams[split[i]] == nil then $bigrams[split[i]] = Hash.new(0)
		end
		$bigrams[split[i]][split[i + 1]] += 1
	end
end

def mcw(word)	#method to find the most common word
	most_common = 0
	max_value = ""
	$bigrams[word].each do |value, max|
		if max > most_common then most_common = max
			max_value = value
		end
	end
	return max_value
end

#create title method
										def create_title(start_word)
										$titleConstruct << "#{start_word}"
										counter += 1
										begin
										nextWord = mcw(start_word)
										if(counter >= 20)
										return
										else
										create_title(nextWord)
										end
										rescue
										#puts "No next Word"
										end
										end

										def create_title(starting_word)
										begin
										result = starting_word
										length = 0
										prev = starting_word

										while length < 19
										current = mcw(prev)
										if (current != "" && current != nil)
										length = length + 1
										result << " "
										result << current
										prev = current
										else
										length = 19
										end
										end
										return result
										rescue
										return result
										end
										end

#function to process each line of a file and extract the song titles
def process_file(file_name)
	puts "Processing File.... "

	begin
		if RUBY_PLATFORM.downcase.include? 'mswin'
			file = File.open(file_name)
			unless file.eof?
				file.each_line do |line|
					# do something for each line (if using windows)
				end
			end
			file.close
		else
			IO.foreach(file_name, encoding: "utf-8") do |line|
				song = cleanup_title(line) #method to clean up the file
				bigramCounts(song)	#calls bigram method and returns the song variable
			end
		end
		puts "Finished. Bigram model built.\n"
	rescue
		STDERR.puts "Could not open file"
		exit 4
	end
end

# Executes the program
def main_loop()
	puts "CSCI 305 Ruby Lab submitted by #{$name}"

	if ARGV.length < 1
		puts "You must specify the file name as the argument."
		exit 4
	end

	# process the file
	process_file(ARGV[0])

	# Get user input
	count = 0 #set count start to zero
	while (count == 0)
		print "Enter a word [Enter 'q' to quit]:"
		line = gets.chomp() #line set to gets.chomp method
		if line == "q"
			count = 1
		else
			$titleConstruct = ""
			counter = nil
			puts create_title(line)
		end
	end
end

if __FILE__== $0
	main_loop()
end
