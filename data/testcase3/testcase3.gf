int x;
int y;
x = 0;
y = 1;
if(x == 0){
    x = x + 1;
    if (x != y) {
        x = 99;
        y = 99;
    } else {
        x = 66;
        y = 66;
    }
}
print(x);
print(y);