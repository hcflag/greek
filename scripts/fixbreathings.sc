
def swapPrecedingBreathings(s: String): String = {
  s.replaceAll(" ̓Ε", " " + CodePointTranscoder.ucodeCodePoint("*e)")).
  replaceAll(" ̔Ε", " " + CodePointTranscoder.ucodeCodePoint("*e(")).
  replaceAll(" ̓Α", " " + CodePointTranscoder.ucodeCodePoint("*a)"))

  // A + smmooth
  // A + rough
}
