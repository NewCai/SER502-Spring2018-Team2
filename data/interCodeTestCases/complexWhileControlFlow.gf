int i;
int x;
int sum;
bool b;
i = 0;
x = 0;
sum = 0;
b = true;

while (b) {
    i = i + 1;
    x = i * i;
    b = i >= 10;
    if (sum > 100) {
        sum = sum + x;
    } else {
        sum = sum / 2;
    }

}