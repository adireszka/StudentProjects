#!/bin/bash

# du -sh ~/backups
# if [ $(du -s ~/backups | cut -f1) -gt 100000000 ]; then echo "Too many backups!"; fi
# (crontab -l 2>/dev/null; echo "0 15 * * * if [ \$(du -s ~/backups | cut -f1) -gt 100000000 ]; then notify-send 'Too many backups!'; fi") | crontab -

(crontab -l 2>/dev/null; echo "0 15 * * * if [ \$(du -s ~/backups | cut -f1) -gt 100000000 ]; then if hash terminal-notifier 2>/dev/null; then terminal-notifier -title 'Backup Alert' -message 'Too many backups!'; else notify-send 'Too many backups!'; fi; fi") | crontab -

exit 0
