const { createInterface } = require('readline')

const rl = createInterface({ input: process.stdin, output: process.stdout, prompt: '' })
/** @type {string[]} */
const input = []

rl.prompt()
rl.on('line', (line) => {
  input.push(line)
})
rl.on('close', () => {
  let t = Number(input[0])

  while (t-- !== 0) {
    const nxk = input[input.length - t * 2 - 2].split(' ')
    const [n, x] = [+nxk[0], +nxk[1]]
    let k = BigInt(nxk[2])
    const s = input[input.length - t * 2 - 1]
    let numZeros = x === 0 ? 1n : 0n,
      pos = x,
      i = 0

    do pos += s[i] === 'L' ? -1 : 1
    while (++i < s.length && pos !== 0)
    if (i === s.length && pos !== 0) {
      console.log(0)
      continue
    }

    for (k -= BigInt(i), ++numZeros, i = 0; i < s.length && k !== 0n; ++i, --k) {
      pos += s[i] === 'L' ? -1 : 1
      if (pos === 0) {
        ++i, --k, ++numZeros
        numZeros += k / BigInt(i)
        break
      }
    }

    console.log(String(numZeros))
  }
})
