/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    let result = [];
    let stack = [{array: arr, index: 0, depth: 0}];

    while (stack.length > 0) {
        let {array, index, depth} = stack.pop();
        while (index < array.length) {
            if (Array.isArray(array[index]) && depth < n) {
                stack.push({array: array, index: index + 1, depth: depth});
                stack.push({array: array[index], index: 0, depth: depth + 1});
                break;
            } else {
                result.push(array[index]);
                index++;
            }
        }
    }

    return result;
};