int x;
int xx;
int xxx;
x =1;
xx =1;
xxx = 0;
while(xxx<100){
xxx = x+xx;
x = xx;
xx = xxx;
}
print(xxx);