#!/bin/bash

cd `dirname $0`

./mysql/bin/mysql mysql --user=root --host=localhost --port=43376 --database=mysql --default-character-set=utf8
