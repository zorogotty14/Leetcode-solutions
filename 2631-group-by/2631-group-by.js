/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
    const grouped = {};
    
    // Iterate over each element in the array
    for (const item of this) {
        // Apply the callback function to get the key
        const key = fn(item);
        
        // If the key does not exist in the object, initialize an empty array
        if (!grouped[key]) {
            grouped[key] = [];
        }
        
        // Add the current item to the array corresponding to the key
        grouped[key].push(item);
    }
    
    // Return the grouped object
    return grouped;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */