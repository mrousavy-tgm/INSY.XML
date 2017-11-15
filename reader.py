from xml.etree import ElementTree as et

doc = et.parse("bookstore.xml")

for child in doc.getroot ():
    print(child.find("title").text + " (" + child.attrib["category"] + ")" + ", " + child.find("year").text + ", from " + child.find("author").text)
