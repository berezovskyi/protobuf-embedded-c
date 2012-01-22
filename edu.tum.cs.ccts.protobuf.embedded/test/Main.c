/*--------------------------------------------------------------------------+
|                                                                          |
| Copyright 2008-2011 Technische Universitaet Muenchen                     |
|                                                                          |
| Licensed under the Apache License, Version 2.0 (the "License");          |
| you may not use this file except in compliance with the License.         |
| You may obtain a copy of the License at                                  |
|                                                                          |
|    http://www.apache.org/licenses/LICENSE-2.0                            |
|                                                                          |
| Unless required by applicable law or agreed to in writing, software      |
| distributed under the License is distributed on an "AS IS" BASIS,        |
| WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. |
| See the License for the specific language governing permissions and      |
| limitations under the License.                                           |
+--------------------------------------------------------------------------*/

/**
 * A c-code sample demonstrating how to use the generated files
 * from the protocol buffers.
 *
 * @author nvpopa
 */
#include "Test.h"
#include <stdio.h>

#include <stdlib.h>

char _buffer[1024*1024];

void print_string(int str_len, FILE *fw, char str[]) {
	int i;
    for(i = 0;i < str_len;++i)
        fprintf(fw, "%c", str[i]);

    fprintf(fw, "\n");
}

int main () {
	int offset = 0, old_offset, i, j;
	int pos, shift = 0;
	char c;
	int size, tmp, cnt = 0;
	struct Person rperson[101];

	FILE *finr = fopen ("Test.in", "rb");

	pos = 0;
	while(fscanf(finr, "%c", &c) != EOF){
		shift = 0;
		size = c;
		_buffer[pos + shift++] = c;
		if (size & 0x80) {
			size = size & 0x7f;
			fscanf(finr, "%c", &c);
			tmp = c;
			size |= tmp << 7;
			_buffer[pos + shift++] = c;
		}
		for (i = pos; i < size + pos; ++ i)
			fscanf(finr, "%c", &_buffer[i + shift]);
		pos += size + shift;
	}

	old_offset = 0;
	while (_buffer[offset] != 0) {
		offset = Person_read_delimited_from(_buffer, &rperson[cnt++], old_offset);
		old_offset = offset;
	}
	fclose(finr);

	FILE *finw = fopen ("Test.out", "wb");
	old_offset = 0;
	for (i = 0; i < cnt; ++ i) {
		offset = Person_write_delimited_to(&rperson[i], _buffer, old_offset);
		for (j = old_offset; j < offset; ++j) {
			fprintf (finw, "%c", _buffer[j]);
		}
		old_offset = offset;
	}
    // printf ("%d ", _buffer[i]);	// for the InputStream read
    fclose(finw);

    if (cnt == 1) {
    	FILE *fw = fopen("Test.properties", "w");
    	fprintf(fw, "id=%ld\n", rperson[0]._id);
    	fprintf(fw, "id64=%lld\n", rperson[0]._id64);
    	fprintf(fw, "sid=%ld\n", rperson[0]._sid);
    	fprintf(fw, "sid64=%lld\n", rperson[0]._sid64);
    	fprintf(fw, "uid=%ld\n", rperson[0]._uid);
    	fprintf(fw, "name1=");
    	print_string(rperson[0]._name1_len, fw, rperson[0]._name1);
    	fprintf(fw, "name2=");
    	print_string(rperson[0]._name2_len, fw, rperson[0]._name2);
    	fprintf(fw, "name3=");
    	print_string(rperson[0]._name3_len, fw, rperson[0]._name3);
    	fprintf(fw, "name4=");
    	print_string(rperson[0]._name4_len, fw, rperson[0]._name4);
    	fprintf(fw, "name5=");
    	print_string(rperson[0]._name5_len, fw, rperson[0]._name5);
    	fprintf(fw, "name6=");
    	print_string(rperson[0]._name6_len, fw, rperson[0]._name6);
    	fprintf(fw, "iq=%f\n", rperson[0]._iq);
    	fprintf(fw, "iqd=%.10lf\n", rperson[0]._iqd);
    	fprintf(fw, "email=%d\n", rperson[0]._email);
    	fprintf(fw, "phonetype=%d\n", rperson[0]._phone);
		fclose(fw);
    }

	return 0;
}
