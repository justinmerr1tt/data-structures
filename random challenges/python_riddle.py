import re
import os
print(os.getcwd())
with open("dictionary.txt",'r') as FILEHANDLE:
   for line in FILEHANDLE:
      pattern = re.search(r"((\w)\2){3}",line)
      if pattern: print(line)