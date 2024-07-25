/**
 * @param {Object|Array} obj
 * @return {boolean}
 */
var isEmpty = function(obj) {
    if (Array.isArray(obj)) {
        // Check if the array has no elements
        return obj.length === 0;
    } else if (typeof obj === 'object' && obj !== null) {
        // Check if the object has no own properties
        return Object.keys(obj).length === 0;
    } else {
        // If it's neither an array nor an object, it's not considered empty
        return false;
    }
};