#!/bin/bash

function end {
  echo "Przerwano działanie programu."
  kill $(jobs -p)
  exit 1
}

function start {
  ./first_crane.sh &
  ./second_crane.sh &
  echo "Uruchomiono dwa dźwigi."
  wait
  kill $(jobs -p)
  echo "Zakończono pracę dźwigów."
}

trap end SIGINT
start