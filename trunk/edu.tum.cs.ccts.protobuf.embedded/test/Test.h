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


#define MAX_REPEATED_LEN 100
#define MAX_STRING_LEN 32


/*******************************************************************
 * Enumeration: Test.proto, line 10
 *******************************************************************/
enum PhoneType {
  _MOBILE = 0,
  _HOME = 1,
  _WORK = 2
};

/*******************************************************************
 * Message: Test.proto, line 16
 *******************************************************************/

/* Maximum size of a serialized PhoneNumber-message, useful for buffer allocation. */
#define MAX_PhoneNumber_SIZE 11

/* Structure that holds a deserialized PhoneNumber-message. */
struct PhoneNumber {
  float _number;
  enum PhoneType _type;
};

/*
 * Serialize a PhoneNumber-message into the given buffer at offset and return
 * new offset for optional next message.
 */
int PhoneNumber_write_delimited_to(struct PhoneNumber *_PhoneNumber, void *_buffer, int offset);

/*
 * Deserialize a PhoneNumber-message from the given buffer at offset and return
 * new offset for optional next message.
 *
 * Note: All fields in _PhoneNumber will be reset to 0 before _buffer is interpreted.
 */
int PhoneNumber_read_delimited_from(void *_buffer, struct PhoneNumber *_PhoneNumber, int offset);



/*******************************************************************
 * Message: Test.proto, line 21
 *******************************************************************/

/* Maximum size of a serialized Person-message, useful for buffer allocation. */
#define MAX_Person_SIZE 6136

/* Structure that holds a deserialized Person-message. */
struct Person {
  int _name1_len;
  char _name1[MAX_STRING_LEN];
  int _name2_len;
  char _name2[MAX_STRING_LEN];
  int _name3_len;
  char _name3[MAX_STRING_LEN];
  int _name4_len;
  char _name4[MAX_STRING_LEN];
  int _name5_len;
  char _name5[MAX_STRING_LEN];
  int _name6_len;
  char _name6[MAX_STRING_LEN];
  signed long _id;
  float _iq;
  char _email;
  enum PhoneType _phone;
  int _strAttr_repeated_len;
  int _strAttr_len[MAX_REPEATED_LEN];
  char _strAttr[MAX_REPEATED_LEN][MAX_STRING_LEN];
  int _intAttr_repeated_len;
  signed long _intAttr[MAX_REPEATED_LEN];
  int _boolAttr_repeated_len;
  char _boolAttr[MAX_REPEATED_LEN];
  int _floatAttr_repeated_len;
  float _floatAttr[MAX_REPEATED_LEN];
  int _enumAttr_repeated_len;
  enum PhoneType _enumAttr[MAX_REPEATED_LEN];
};

/*
 * Serialize a Person-message into the given buffer at offset and return
 * new offset for optional next message.
 */
int Person_write_delimited_to(struct Person *_Person, void *_buffer, int offset);

/*
 * Deserialize a Person-message from the given buffer at offset and return
 * new offset for optional next message.
 *
 * Note: All fields in _Person will be reset to 0 before _buffer is interpreted.
 */
int Person_read_delimited_from(void *_buffer, struct Person *_Person, int offset);



/*******************************************************************
 * Message: Test.proto, line 39
 *******************************************************************/

/* Maximum size of a serialized AddressBook-message, useful for buffer allocation. */
#define MAX_AddressBook_SIZE 37

/* Structure that holds a deserialized AddressBook-message. */
struct AddressBook {
  int _address_len;
  char _address[MAX_STRING_LEN];
};

/*
 * Serialize a AddressBook-message into the given buffer at offset and return
 * new offset for optional next message.
 */
int AddressBook_write_delimited_to(struct AddressBook *_AddressBook, void *_buffer, int offset);

/*
 * Deserialize a AddressBook-message from the given buffer at offset and return
 * new offset for optional next message.
 *
 * Note: All fields in _AddressBook will be reset to 0 before _buffer is interpreted.
 */
int AddressBook_read_delimited_from(void *_buffer, struct AddressBook *_AddressBook, int offset);



/*******************************************************************
 * Message: Test.proto, line 43
 *******************************************************************/

/* Maximum size of a serialized Foo-message, useful for buffer allocation. */
#define MAX_Foo_SIZE 2

/* Structure that holds a deserialized Foo-message. */
struct Foo {
};

/*
 * Serialize a Foo-message into the given buffer at offset and return
 * new offset for optional next message.
 */
int Foo_write_delimited_to(void *_buffer, int offset);

/*
 * Deserialize a Foo-message from the given buffer at offset and return
 * new offset for optional next message.
 *
 * Note: Foo-messages are empty.
 */
int Foo_read_delimited_from(void *_buffer, int offset);

