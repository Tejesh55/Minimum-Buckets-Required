import collections as c
def bucket_create(a):
    count = c.Counter(a)
    n=len(a)
    num=0
    bucket=0
    while(num < n):
        Keymax = max(count, key=count.get)
        key_val = count[Keymax]
        if (key_val >= 2):
            v = key_val + (key_val - 1)
            bucket += 1
            num += v
        count[Keymax] -= 1
    if(num<n):
        bucket+=(n-num)
    return bucket
a=[1,1,1,1,1,1,2,2,2,2,2,2,4,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,3,3,3,10,10,10,11,11,11,12,12,13,13,14,14,15,15,16,16,17,17,18,18,19,20]
print(bucket_create(a))