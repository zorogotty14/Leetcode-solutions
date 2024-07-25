/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function(fn, t) {
    
    return async function(...args) {
        return new Promise((resolve, reject) => {
            // Set a timeout to reject the promise with "Time Limit Exceeded"
            const timeoutId = setTimeout(() => {
                reject("Time Limit Exceeded");
            }, t);

            // Call the provided async function
            fn(...args)
                .then(result => {
                    clearTimeout(timeoutId); // Clear the timeout if function resolves
                    resolve(result);
                })
                .catch(error => {
                    clearTimeout(timeoutId); // Clear the timeout if function rejects
                    reject(error);
                });
        });
    }
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */