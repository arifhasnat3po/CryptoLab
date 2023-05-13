def encrypt_row_column(plaintext, key):
    # Remove any spaces from the key and convert to uppercase
    key = ''.join(key.split()).upper()

    # Determine the size of the grid
    cols = len(key)
    rows = len(plaintext) // cols
    if len(plaintext) % cols != 0:
        rows += 1

    # Add padding to the plaintext if necessary
    padding = '_' * (rows * cols - len(plaintext))
    plaintext += padding

    # Create the grid
    grid = [['' for _ in range(cols)] for _ in range(rows)]

    # Fill the grid with the plaintext
    index = 0
    for row in range(rows):
        for col in range(cols):
            grid[row][col] = plaintext[index]
            index += 1

    # Sort the columns of the grid based on the key
    sorted_cols = sorted(range(cols), key=lambda k: key[k])
    ciphertext = ''
    for col in sorted_cols:
        for row in range(rows):
            ciphertext += grid[row][col]

    return ciphertext

plaintext = "Arif Hasnat"
key = "CRYPTO"

ciphertext = encrypt_row_column(plaintext, key)
print("Encrypted: " +ciphertext)


def decrypt_row_column(ciphertext, key):
    # Remove any spaces from the key and convert to uppercase
    key = ''.join(key.split()).upper()

    # Determine the size of the grid
    cols = len(key)
    rows = len(ciphertext) // cols

    # Create the grid
    grid = [['' for _ in range(cols)] for _ in range(rows)]

    # Fill the grid with the ciphertext
    index = 0
    for col in range(cols):
        sorted_row = sorted(range(rows), key=lambda k: key.index(key[k]))
        for row in sorted_row:
            grid[row][col] = ciphertext[index]
            index += 1

    # Read off the plaintext from the grid
    plaintext = ''
    for row in range(rows):
        for col in range(cols):
            plaintext += grid[row][col]

    # Remove any padding characters from the plaintext
    padding = plaintext.count('_')
    plaintext = plaintext[:-padding]

    return plaintext
print("Decrypted plaintext: " +plaintext)