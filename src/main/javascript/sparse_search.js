/**
 * 10.5 Sparse Search
 * 7/8/20
 * 
 * @param {*} array 
 * @param {*} s 
 */
function sparse_search(array, s) {
    let lower = 0, upper = array.length - 1; 
    while (array[lower] == '') {
        lower++; 
    }
    while (array[upper] == '') {
        upper--; 
    }
    console.log("lower " + lower); 
    console.log("upper " + upper); 
    var i; 
    for (i = 0; i < array.length; i++) {
        if (array[i] == s) {
            return i; 
        }
    }
}
let a = ['', '', 1, 3, '', 4, '', 5, '', 6, 7, 8, ''];
console.log("sparseSearch: " + sparse_search(a, 5));