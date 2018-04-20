int sum;
int count;
int i;
int j;
sum = 0;
count = 10;
i = 0;
j = count;
while(i< j){
	sum = sum + count;
	count = count - 1;
    i = i + 1;
}
print(sum);
