int i;
int j;
i = 1;
j = 0;
while(i<10){
	while(j<10){
		if(i!=j){
			print(i);
			print(j);
		}
		j=j+1;
	}
	i=i+1;
	j=0;
}