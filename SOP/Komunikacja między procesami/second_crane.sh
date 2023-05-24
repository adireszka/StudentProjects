#!/bin/bash

licznik=0

while true; do
  if [ ! "$(ls -A bufor)" ] && ! pgrep -x "first_crane.sh" >/dev/null; then
    break
  fi

  for plik in bufor/*
  do
    if [ -f "$plik" ]; then
      mv "$plik" second
      licznik=$((licznik+1))
      echo "Przeniesiono plik $plik do drugiego folderu"
    fi
  done
done