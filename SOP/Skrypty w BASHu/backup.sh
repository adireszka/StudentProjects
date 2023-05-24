#!/bin/bash

# find /Users/$(whoami)/Documents -type f -name "*.txt"
# tar -czvf archive.tar.gz $(find /Users/$(whoami)/Documents -type f -name "*.txt")
# tar -czvf "$(whoami)_backup_$(date +'%d-%m-%Y_%H:%M:%S')".tar.gz $(find /Users/$(whoami)/Documents -type f -name "*.txt")
# tar -czvf ~/backups/"$(whoami)_backup_$(date +'%d-%m-%Y_%H:%M:%S')".tar.gz $(find /Users/$(whoami)/Documents -type f -name "*.txt")

(crontab -l 2>/dev/null; echo "50 15 * * * tar -czvf ~/backups/'$(whoami)_backup_$(date +'%d-%m-%Y_%H:%M:%S')'.tar.gz $(find /Users/$(whoami)/Documents -type f -name '*.txt')") | crontab -

exit 0
