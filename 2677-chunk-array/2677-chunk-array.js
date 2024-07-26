/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function(arr, size) {
    // Initialize an empty array to hold the chunks
    let chunkedArray = [];
    
    // Iterate over the array in steps of 'size'
    for (let i = 0; i < arr.length; i += size) {
        // Slice the array from i to i+size and push it to chunkedArray
        chunkedArray.push(arr.slice(i, i + size));
    }
    
    // Return the chunked array
    return chunkedArray;
};
