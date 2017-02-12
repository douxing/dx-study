this article is a brief summary of [here](https://linuxacademy.com/blog/linux/introduction-using-diff-and-patch/)

## diff

`diff originalfile updatedfile` is the simplest form.
It will output a file with NO context.

`diff -c originalfile updatedfile` will output the context.

`diff -u originalfile updatedfile` will output the context with unified version.

specifiy the context lines with `-C 2` or `-U 2` or `-2` what ever format you chosse.

> Quoting the GNU diff man page: “For proper operation, patch typically needs at least two lines of context.”

> diff two directory will also be a good practice for multiple file patches.

## patch

`patch originalfile -i patchfile.patch -o updatedfile`
will patch the file.

patch will strip away all directories in front of the filename,
add `-pN` to prevent this action, N is the slash count before the actual file.

`-R` will do a reverse patch, which will __unpatch__ back to the original version.

