import sys
from difflib import SequenceMatcher
text1 = open(sys.argv[1]).read()
text2 = open(sys.argv[2]).read()
m = SequenceMatcher(None, text1, text2)
ratio = m.ratio()
ratio = ratio*100
# print 'Match: {0:.2%}'.format(m.ratio());
print 'Match: %.2f'%ratio;