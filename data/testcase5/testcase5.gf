int sum;
int count;
sum = 0;
count = 10;
while(sum < count){
	if(count>0){
		sum = sum + count;
		count = count - 1;
	}
}
print(sum);
