#include <stdio.h>
#include <time.h>
#include <stdlib.h>

void staticFunction(void){
    static int a[1];
}

void stackFunction(void){
    static int b[1];
}

void heapFunction(void){
    static int c[1];
}

int main(void){
    struct timespec time1, time2;
    clock_gettime(CLOCK_REALTIME, &time1);
    for(int i = 0; i < 1000000; i++){
        staticFunction();
    }
    clock_gettime(CLOCK_REALTIME, &time2);
    printf("It took: %ld nanoseconds to call staticFunction 1,000,000 times \n", time2.tv_nsec - time1.tv_nsec);


    clock_gettime(CLOCK_REALTIME, &time1);
    for(int i = 0; i < 1000000; i++){
        stackFunction();
    }
    clock_gettime(CLOCK_REALTIME, &time2);
    printf("It took: %ld nanoseconds to call stackFunction 1,000,000 times \n", time2.tv_nsec - time1.tv_nsec);


    clock_gettime(CLOCK_REALTIME, &time1);
    for(int i = 0; i < 1000000; i++){
        heapFunction();
    }
    clock_gettime(CLOCK_REALTIME, &time2);
    printf("It took: %ld nanoseconds to call heapFunction 1,000,000 times \n", time2.tv_nsec - time1.tv_nsec);
}