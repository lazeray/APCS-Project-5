import subprocess,os,regex,pexpect,sys

class WrappedLogger:
    def __init__(self, logger):
        self.logger = logger

    def write(self, data):
        if isinstance(data, bytes):
            data = data.decode('utf-8')
        self.logger.write(data)

    def flush(self):
        self.logger.flush()

my_logger = WrappedLogger(sys.stdout)

class Project(object):
    def __init__(self,folder_path):
        self.folder_path = folder_path
        self.has_all_files = False
        self.runs = False
        self.code_works = False
        self.error_checking = False
        self.class_name = "Main"


    def clear_terminal(self):
        # subprocess.call("clear" if os.name == "posix" else "cls")
        return

    def run_java_class(self):
        try:
            child = pexpect.spawn(f'java -cp {self.folder_path} {self.class_name}',logfile=my_logger,echo=False)
            self.runs = True
            #print out what it shows

            child.expect('Player: 1:')  # modify as needed
            child.sendline('Y')
            child.expect('Enter the column you would like to place your megapiece at.')  # modify as needed
            child.sendline('4')


            child.expect("Player: 2:")
            child.sendline("Y")
            child.expect("Enter the column you would like to place your megapiece at.")
            child.sendline("14")
            child.expect("Player: 1:")
            child.sendline("1")
            child.expect("Player: 2:")
            child.sendline("1")
            child.expect("Player: 1:")
            child.sendline("2")
            try:
                child.expect("player: 1 has won!",timeout=2)
                self.code_works = True
                self.clear_terminal()
                print("[✔︎] Passed Game Run")
            except:
                print("failed run")

        except Exception as e:
            print(e)

    def check_class_files(self):
        class_files = ['Board.class', 'Main.class', 'MegaPiece.class', 'Piece.class']
        #get all files in directory, and check if all of he class_files are inside
        files = os.listdir(self.folder_path)
        for file in files:
            if file in class_files:
                class_files.remove(file)
        if len(class_files) > 0:
            print(f"Missing {len(class_files)} class files: {class_files}")
            self.has_all_files=True
        else:
            print("[!] all files")
            self.has_all_files=True
    def error_check(self):
        child = pexpect.spawn(f'java -cp {self.folder_path} {self.class_name}',logfile=my_logger,echo=False,timeout=1)
        
        try:
            child.expect("Player: 1:")
            child.sendline("p")
            child.expect("Please enter a valid answer",timeout=1)
            child.sendline("y")
            child.expect("Enter the column you would like to place your megapiece at.",timeout=1)
            child.sendline("16")
            child.expect("Not a valid piece placement.")
            child.sendline("Y")
            child.expect("Enter the column you would like to place your megapiece at.")
            child.sendline("5")
            child.expect("Player: 2:")
            child.sendline("p")
            child.expect("Please enter a valid answer")
            child.sendline("n")
            child.expect("Enter the column you would like to place your piece at.")
            child.sendline("11")
            child.expect("Player: 1:")
            child.sendline("4")
            child.expect("Player: 2:")
            child.sendline("y")
            child.expect("Enter the column you would like to place your megapiece at.")
            child.sendline("11")
            child.expect("Player: 1:")
            child.sendline("4")
        except:
            print("shit failed lao")

        try:
            child.expect("player: 1 has won!",timeout=2)
            self.error_checking = True
            self.clear_terminal()
            print("[✔︎] Passed Debug Tests")
        except:
            print("failed Debugging")
    def run_tests(self):
        self.check_class_files()
        self.run_java_class()
        self.error_check()

    def print_outcomes(self):
        print(f"Has all files: {self.has_all_files}")
        print(f"Runs: {self.runs}")
        print(f"Code Works: {self.code_works}")
        print(f"Error Checking: {self.error_checking}")

if __name__ == "__main__":
    pro_obj = Project('/Users/edwardhe/Documents/APCS-Project-5/autograder/projects_unzipped/Aiden')
    pro_obj.run_tests()
    pro_obj.clear_terminal()
    pro_obj.print_outcomes()
    #print what tests it has passed

