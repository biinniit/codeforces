const { createInterface } = require('readline')

const rl = createInterface({input: process.stdin, output: process.stdout, prompt: '' })
const input = []

rl.prompt()
rl.on('line', (line) => {
  input.push(line)
})
rl.on('close', () => {
  let t = parseInt(input[0])

  while(t-- !== 0) {
    const n = parseInt(input[input.length - t - 1])
    console.log(Math.floor(n / 15) * 3 + (n % 15 < 2 ? n % 15 + 1 : 3))
  }
})
