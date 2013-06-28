#!/usr/bin/env ruby
if __FILE__ == $0
        prefix_date=Time.now.strftime( '%F'       ) # %F = YYYY-MM-DD
        prefix_time=Time.now.strftime( '%H:%M:%S' )

        prefix = prefix_date
        prefix += "-"
        prefix += prefix_time

        bundle_name = ARGV[0] if (ARGV[0])
        bundle_name = `pwd`.split('/').last.chomp if bundle_name.nil? 
        bundle_name += ".git.bundle"

	bundle_file = prefix
	bundle_file += "-"
        bundle_file += bundle_name

        puts "Backing up to bundle #{bundle_file}"
        `git bundle create /Users/barbarabickham/Dropbox/backup/git-repos/#{bundle_file} --all`
end
