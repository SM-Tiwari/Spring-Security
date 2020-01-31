#!/bin/bash

get_pid() {
    pgrep -f "java.*fcmclient"
}

echo -n "Stopping FCM Client..."

pid=`get_pid`
[ -n "$pid" ] && kill $pid
RETVAL=$?
cnt=30
while [ $RETVAL = 0 -a $cnt -gt 0 ] &&
    { get_pid > /dev/null ; } ; do
    sleep 1
    ((cnt--))
done

echo "stopped."
echo