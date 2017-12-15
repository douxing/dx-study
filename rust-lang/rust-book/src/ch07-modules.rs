/*
The 'mod' keyword declares a new module, Code within the module appears:
1. either immediately following this declaration within curly brackets
2. or in another file.

By default, functions, types, constants, and modules are private.
The 'pub' keyword makes an item public
and therefore visible outside its namespace.

The use keyword brings modules, or the definitions inside modules,
into scope so it’s easier to refer to them.
*/

/*
Rules of Module Filesystems

1. If a module named foo has no submodules,
   you should put the declarations for foo in a file named foo.rs.
2. If a module named foo does have submodules,
   you should put the declarations for foo in a file named foo/mod.rs.
*/

/*
Privacy Rules
Overall, these are the rules for item visibility:

1. If an item is public, it can be accessed through
   any of its parent modules.
2. If an item is private it can be accessed only by
   - its immediate parent module
   - and any of the parent’s child modules. (by dx: siblings of the item)
*/

