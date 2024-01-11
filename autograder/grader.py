import os,zipfile


def get_all_zips():
    files = os.listdir("./projects")
    zips = []
    for f in files:
        if f.endswith(".zip"):
            zips.append(f)
    return zips

def unzip_file(file_path, extraction_path):
    with zipfile.ZipFile(file_path, 'r') as zip_ref:
        zip_ref.extractall(extraction_path)

def check_submitted_right(file_path,zip_name):
    #if theres .class files then create a new folder and put them all inside
    all_fls = os.listdir("./projects_unzipped/")
    for fl in all_fls:
        if fl.endswith(".class"):
            os.mkdir(f"./projects_unzipped/{zip_name}")
            os.rename(f"./projects_unzipped/{fl}", f"./projects_unzipped/{zip_name}/{fl}")
            return True



#finish it so it reads the 






print("[!] Hello! Welcome to Edwards project Grader...")
print("[~] Please wait while I look for files")
all_zips = get_all_zips()
print(f"[!] Found all zips, currently there are {len(all_zips)} Projects to grade")
input("press Enter to start the proccess")
for zip in all_zips:
    print(f"[~] Unzipping {zip}")
    unzip_file(f"./projects/{zip}", "./projects_unzipped")
    print(f"[~] Unzipped! {zip}")
    print(f"[~] Checking if {zip} was submitted correctly")
    if check_submitted_right(f"./projects_unzipped/{zip}", zip):
        print(f"[~] {zip} was submitted correctly")
    else:
        print(f"[!] {zip} was not submitted correctly, please check it and try again")
        exit()
input(f"Most if not all files Unzipped, Press enter to start Grading")
