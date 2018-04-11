int x;
int i;
int sum;
sum = 0;
i = 5;
if (i < 6) {
    x = i * 2;
    if (x > 10) {
        x = x - 5;
    }

} else {
    x = i - 2;
    if (x < 10) {
        x = x + 5;
    }
}

sum = x * x + 1;