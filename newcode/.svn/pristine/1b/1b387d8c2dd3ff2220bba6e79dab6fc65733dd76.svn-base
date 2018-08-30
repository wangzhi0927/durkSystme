#!/bin/bash
#该脚本用于启动、停止dpm服务，与JAR放于同一目录
################################################################
#需要操作的服务信息，注册服务eureka必须首先启动
#服务代码集合
SERVER_CODES=(eureka sleuth config db zuul web unity)
#服务名称集合
SERVER_NAMES=(注册服务 服务跟踪 配置服务 数据服务 路由服务 web服务 unity服务)
#服务启动使用的JAR文件集合
JARS=(dpm-eureka.jar dpm-sleuth.jar dpm-config.jar dpm-db.jar dpm-zuul.jar dpm-web.jar dpm-unity.jar)
#JAR文件所在路径的集合
JARS_PATHS=(/usr/local/dpm2.0 /usr/local/dpm2.0 /usr/local/dpm2.0 /usr/local/dpm2.0 /usr/local/dpm2.0 /usr/local/dpm2.0 /usr/local/dpm2.0)
#手动设置JAVA_HOME，不设置时，Jenkins调用脚本执行会失败。
#export JAVA_HOME=/usr/local/jdk/jdk1.8.0_171

start(){ 
	local SERVER_CODE=
	local SERVER_NAME=
	local JAR_NAME=
	local JAR_PATH=
	local command=
	#接受输入的第一个参数，暂时只支持一个参数，“all”：启动所有，SERVER_CODES[i]：启动某一个服务
	local PARAM="$1"
	local cmd2ok=0
	local cnt=0
	local okcnt=0
	echo "---------------------------开始启动服务..."
	for(( i=0;i<${#SERVER_CODES[@]};i++))
		do
		SERVER_CODE=${SERVER_CODES[$i]}
		SERVER_NAME=${SERVER_NAMES[$i]}
		JAR_NAME=${JARS[$i]}
		JAR_PATH=${JARS_PATHS[$i]}
		if [ "$PARAM" == "all" ] || [ "$PARAM" == "$SERVER_CODE" ]; then
			cmd2ok=1
			C_PID="0"
			cnt=0
			PID=`ps -ef |grep $(echo $JAR_NAME |awk -F/ '{print $NF}') | grep -v grep | awk '{print $2}'` 
			if [ -n "$PID" ] 
				then
				echo "$SERVER_CODE---$SERVER_NAME:己经运行,PID=$PID"
			else
				cd $JAR_PATH
				if [ ! -d log ];then
                    mkdir -p log
                fi
				#删除日志文件
				#rm -f $JAR_PATH/nohup.out
				command="nohup $JAVA_HOME/bin/java -Xms8m -Xmx64m -jar $JAR_NAME"
				# exec $command > $JAR_PATH/$SERVER_CODE$(date +%Y%m%d%H%M%S).log &
				exec $command > $JAR_PATH/log/$SERVER_CODE.log &
				PID=`ps -ef |grep $(echo $JAR_NAME |awk -F/ '{print $NF}') | grep -v grep | awk '{print $2}'` 
				cnt=0
				if [ "$SERVER_CODE" == "eureka" ] ;
					then
					echo 正在启动注册服务……
					sleep 20
				fi
				while [ -z "$PID" ]
					do
					# if (($cnt==30))
						# then
						# echo "$SERVER_CODE---$SERVER_NAME:$cnt秒内未启动，请检查！"
						# break
					# fi
					# cnt=$(($cnt+1))
					# sleep 1s
					# echo sleep $cnt
					PID=`ps -ef |grep $(echo $JAR_NAME |awk -F/ '{print $NF}') | grep -v grep | awk '{print $2}'` 
				done
				okcnt=$(($okcnt+1))
				echo "$SERVER_CODE---$SERVER_NAME:己经成功启动,PID=$PID"
				#########
				# if [ "$SERVER_CODE" == "eureka" ] ;
					# then
					# echo "$SERVER_CODE---$SERVER_NAME:启动中..."
					# sleep 30s
				# fi 
			fi
		fi
	done
	if (($cmd2ok==0))
		then
		echo "输入错误！" 
	else
		echo "---------------------------本次启动:$okcnt个服务"
	fi
}

stop(){ 
	local SERVER_CODE=
	local SERVER_NAME=
	local JAR_NAME=
	local command="sh service.sh stop"
	local cmd2="$1"
	local cmd2ok=0
	#local C_PID="0"
	local okcnt=0
	echo "---------------------------开始停止服务..."
	for(( i=0;i<${#SERVER_CODES[@]};i++))
		do
		SERVER_CODE=${SERVER_CODES[$i]}
		SERVER_NAME=${SERVER_NAMES[$i]}
		JAR_NAME=${JARS[$i]}
		if [ "$cmd2" == "all" ] || [ "$cmd2" == "$SERVER_CODE" ]; then
			cmd2ok=1
			PID=`ps -ef |grep $(echo $JAR_NAME |awk -F/ '{print $NF}') | grep -v grep | awk '{print $2}'` 
			if [ -n "$PID" ]
				then
				echo "$SERVER_NAME:PID=$PID准备结束"
				kill -9 $PID
				PID=`ps -ef |grep $(echo $JAR_NAME |awk -F/ '{print $NF}') | grep -v grep | awk '{print $2}'`
				while [ -n "$PID" ]
					do
					sleep 1s
					PID=`ps -ef |grep $(echo $JAR_NAME |awk -F/ '{print $NF}') | grep -v grep | awk '{print $2}'`
				done
				echo "$SERVER_NAME:成功结束"
				okcnt=$(($okcnt+1))
			else
				echo "$SERVER_NAME:未运行"
			fi 
		#done 
		fi
	done
	if (($cmd2ok==0))
		then
		echo "输入错误！" 
	else
		echo "---------------------------本次共停止:$okcnt个服务" 
	fi
}

case "$1" in 
start) 
start "$2"
exit 1
;; 
stop) 
stop "$2"
;; 
restart) 
stop "$2"
start "$2"
;; 
*) 
echo "command1: start|stop|restart" 
exit 1 
;; 
esac