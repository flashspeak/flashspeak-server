
form Myform
  word In_file "/Users/wbillingsley/Documents/onetwothree.wav"
  word Out_file "/Users/wbillingsley/Documents/onetwothree.png"
endform

Times
Font size... 14
Line width... 1
Black

sound = Read from file: in_file$ 
selectObject: sound
spectrogram = To Spectrogram: 0.005, 5000, 0.002, 20, "Gaussian"

Viewport... 0 7 1 4

selectObject: spectrogram
Paint... 0 0 0 0 100 yes 45 6 0 no
Save as 600-dpi PNG file: out_file$ 

