# ProListDialog
This dialog shows a list of item. It uses Recycler View to show the items

Add it in your root build.gradle at the end of repositories:

```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Add the dependency

```
	dependencies {
	        implementation 'com.github.shaon2016:ProListDialog:Tag'
	}
```

How to use it

In your activity or fragment

```
            RvDialog(this).show {
                title("Title")
                listValues(data) { text, position ->
                    this@MainActivity.tv.text = "Selected item: $text"

                    dismiss()
                }

                negativeButton()
            }
```
