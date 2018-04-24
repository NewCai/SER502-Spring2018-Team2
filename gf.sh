arg_num=$#
arg1=$1
arg2=$2
compiler_path='build/libs/GFCompiler.jar'
runtime_path='build/libs/GFRuntime.jar'

instruction() {
	echo "Please execute the script in the following format"
	echo "*******************Compile GodFather source file********************"
	echo "./gf.sh -c /path/to/your/source.gf"
	echo "*******************Run GodFather intermediate code********************"
	echo "./gf.sh -r /path/to/your/code.inter"
}

compile() {
	java -jar ${compiler_path} ${arg2}
}

run() {
	java -jar ${runtime_path} ${arg2}
}

execute() {
	if [ $arg1 = "-c" ]
	then 
		compile
	elif [ $arg1 = "-r" ]
	then 
		run
	else
		instruction
	fi	
}

if test $[arg_num] -eq 2
then 
	execute
else 
	instruction
fi

