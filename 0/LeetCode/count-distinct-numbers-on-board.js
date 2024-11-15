/**
 * @param {number} n
 * @return {number}
 */
var distinctIntegers = function (n) {
    if (n != 1) return n - 1;
    return 1;
    /*
    const numberList = []
    for (let i = 1; i <n; i++){
        numberList.push(n%(i+1))
    }
    return numberList.length*/
};
