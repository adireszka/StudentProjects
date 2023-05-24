#!/bin/bash

limit=3
licznik=0

for plik in first/*
do
  if [ -f "$plik" ]; then
    while  [ $(ls -1 bufor | wc -l) -ge "$limit" ]; do
      echo "Bufor pełny. Oczekiwanie na zwolnienie miejsca..."
      sleep 1
    done
    if [ $(ls -1 bufor | wc -l) -lt "$limit" ]; then
      mv "$plik" bufor
      licznik=$((licznik+1))
      echo "Przeniesiono plik $plik do bufora"
    fi
  fi
done