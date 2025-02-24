
self.onmessage = function(event) {
    if (event.data === 'start') {
        while (true) {
            const randomNumber
                = Math.floor(Math.random() * 8100) + 10
            if (randomNumber < 100)
                postMessage(randomNumber)
        }
    }
}
