/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    const cache = {};
    let callCount = 0;

    const memoizedFn = function(...args) {
        const key = JSON.stringify(args);
        if (!(key in cache)) {
            callCount++;
            cache[key] = fn(...args);
        }
        return cache[key];
    };

    memoizedFn.getCallCount = function() {
        return callCount;
    };

    return memoizedFn;
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */