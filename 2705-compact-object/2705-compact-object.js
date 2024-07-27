/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function(obj) {
    if (Array.isArray(obj)) {
        // Process array
        return obj.reduce((acc, item) => {
            const compactedItem = compactObject(item);
            if (Boolean(compactedItem)) {
                acc.push(compactedItem);
            }
            return acc;
        }, []);
    } else if (obj !== null && typeof obj === 'object') {
        // Process object
        return Object.keys(obj).reduce((acc, key) => {
            const compactedValue = compactObject(obj[key]);
            if (Boolean(compactedValue)) {
                acc[key] = compactedValue;
            }
            return acc;
        }, {});
    } else {
        // Return the value if it's not an object/array
        return obj;
    }
};