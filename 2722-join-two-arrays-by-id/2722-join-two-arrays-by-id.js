/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    let map = new Map();

    // Helper function to merge two objects
    function mergeObjects(obj1, obj2) {
        let merged = { ...obj1, ...obj2 };
        return merged;
    }

    // Add or merge objects from arr1 to the map
    for (let obj of arr1) {
        map.set(obj.id, obj);
    }

    // Add or merge objects from arr2 to the map
    for (let obj of arr2) {
        if (map.has(obj.id)) {
            let existingObj = map.get(obj.id);
            let mergedObj = mergeObjects(existingObj, obj);
            map.set(obj.id, mergedObj);
        } else {
            map.set(obj.id, obj);
        }
    }

    // Convert the map values to an array and sort by id
    let joinedArray = Array.from(map.values()).sort((a, b) => a.id - b.id);

    return joinedArray;
};