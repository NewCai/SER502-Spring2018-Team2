int i;
int x;
int sum;
i = 0;
x = 0;
sum = x;
while (i < 10) {
    i = i + 1;
    x = i * i;
    sum = sum + (x - i);
}

sum = sum - 1;