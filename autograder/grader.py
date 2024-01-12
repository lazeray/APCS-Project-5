import os,zipfile,Project


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

input(f"Most if not all files Unzipped, Press enter to start Grading")

drs = os.listdir("./projects_unzipped")
#check if its a folder, if its not a folder then remove it
for dr in drs:
    if not os.path.isdir(f"./projects_unzipped/{dr}"):
        drs.remove(dr)
    if "__" in dr:
        drs.remove(dr)
for dr in drs:
    fz = Project.Project(f"./projects_unzipped/{dr}")
    fz.run_tests()
    fz.print_outcomes()

