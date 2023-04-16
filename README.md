# conway

Minimal demonstration Clojure code for Conway's Game of Life

Lee Spector (lspector@amherst.edu), 2023

## Usage

Three versions are included.

These two print successive states of the world to the console:

- character: represents cell states as spaces and `*` characters

- numeric: represents cell states using the numbers `0` and `1`

This one uses [Quil](http://quil.info) for graphics 

- quil: also represents cell states as spaces and `*` characters

If you are using a Clojure IDE you should be able to run any version by opening the corresponding file and evaluating all of its contents, including the commented-out top-level call at the bottom. Note that the quil graphics window may be initially hidden by your IDE window in some setups.

To run the character version from the command line using the [Clojure CLI tools](https://clojure.org/guides/deps_and_cli), `cd` into the project directory and use this command (possibly specifying a different number of steps):

```
clj -X conway.character/life :steps 50
```

For the numeric version, use a command like this:

```
clj -X conway.numeric/life :steps 50
```

The quil version does not take a step limit, and it will continue to run until you close the quil graphics window:

```
clj -X conway.quil/life
```

Aside from the step limit, no command-line arguments are currently provided, but you can change them in the source code and/or extend the `life` function to take other arguments, using the code for handling `:steps` as an example.

