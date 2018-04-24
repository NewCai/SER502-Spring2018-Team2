compiler_path='build/libs/GFCompiler.jar'
runtime_path='build/libs/GFRuntime.jar'

echo
echo "Compile testcase 1"
java -jar ${compiler_path} ./data/testcase1/testcase1.gf
echo
echo "Exectute testcase 1"
java -jar ${runtime_path} ./data/testcase1/testcase1.inter

echo
echo "Compile testcase 2"
java -jar ${compiler_path} ./data/testcase2/testcase2.gf
echo
echo "Exectute testcase 2"
java -jar ${runtime_path} ./data/testcase2/testcase2.inter

echo
echo "Compile testcase 3"
java -jar ${compiler_path} ./data/testcase3/testcase3.gf
echo
echo "Exectute testcase 3"
java -jar ${runtime_path} ./data/testcase3/testcase3.inter

echo
echo "Compile testcase 4"
java -jar ${compiler_path} ./data/testcase4/testcase4.gf
echo
echo "Exectute testcase 4"
java -jar ${runtime_path} ./data/testcase4/testcase4.inter

echo
echo "Compile testcase 5"
java -jar ${compiler_path} ./data/testcase5/testcase5.gf
echo
echo "Exectute testcase 5"
java -jar ${runtime_path} ./data/testcase5/testcase5.inter

echo
echo "Compile testcase 6"
java -jar ${compiler_path} ./data/testcase6/testcase6.gf
echo
echo "Exectute testcase 6"
java -jar ${runtime_path} ./data/testcase6/testcase6.inter

echo
echo "Compile testcase 7"
java -jar ${compiler_path} ./data/testcase7/testcase7.gf
echo
echo "Exectute testcase 7"
java -jar ${runtime_path} ./data/testcase7/testcase7.inter

echo
echo "Compile testcase 8"
java -jar ${compiler_path} ./data/testcase8/testcase8.gf
echo
echo "Exectute testcase 8"
java -jar ${runtime_path} ./data/testcase8/testcase8.inter