# U-net-Image-Segmentation
U-net is an Image segmentation Algorithm which uses CNN blocks to extract features and the rebuilding blocks are connected to their corresponding level to retain the input shape.  



Guide to install jupyter notebook.
	https://jupyter.org/install

Guide to open a jupyter notebook.
	https://jupyter.readthedocs.io/en/latest/running.html
-----------------------------------------------------------------------------------------------------------------------------------------

REQUIRED PACKAGES:

openCV- pip install opencv-contrib-python
Tensorflow- pip install tensorflow
keras- pip install keras
scipy- pip install scipy 
numpy- pip install numpy
skimage-pip install scikit-image
matplotlib-python -m pip install -U matplotlib


-------------------------------------------------------------------------------------------------------------------------------------------
Download the code files and the .tif files
-------------------------------------------------------------------------------------------------------------------------------------------
Open the Image_gen_addn_ipynb first.


Make the following changes  :

1. Install tifffile.
	pip install tifffile 
	
2. Comment out-
	from google.colab import drive
	drive.mount('/content/drive/')
	These are required only if the file is run on Google Colab.
3.Paths
	Assuming you have downloaded the files to download folder.
	the directory would be 
	train_image_path-      ~/Downloads/train-volume.tif      # for train file	
	train_mask_path-       ~/Downloads/train-labels.tif        # for mask files
	test_path-                   ~/Downloads/test-volume.tif.      # for test files
	save_path-  "give a suitable location(Include the / after the path)" # save location
	All the directories go in the main function.
4. names.
	give appropriate names to the files.
	train_image_filename=   "name_image.npy"
	train_mask_filename=    "name_mask.npy"
	test_image_filename=    "name_test.npy"
5.Image sizes.
	Set the output image size to the desired size range. Anywhere between (128x128) to the full size 	of the image. 
	output_shape= (height,width)
	If the output image needs to be of full size then toggle the "full_size" to True in the main function in 	the parameters passed to Augment(). If it is a smaller image set "full_size" to False.
	Size_of_test_image=(height,width) 	
6. Set the parameters.
	'tiff_file': True id .tif, False otherwise. To either load from tif images or other image formats
	'aug_ration': Number of images to be generated from each image
	'transforms': True if transforms are needed, False otherwise. if the image needs to have additional 			    transforms like flipping.
	'save': if True saves the numpy files to the desired location.

Run the file. 
-------------------------------------------------------------------------------------------------------------------------------------------


Open the Unet_addn_data_package.ipynb

Make the following changes:

1.Comment out-
	from google.colab import drive
	drive.mount('/content/drive/')
	These are required only if the file is run on Google Colab.
	
2 Verify that all the packages are installed  by running the imports cell.
	install if any package is missing.
	pip install <name of the package>
3.Go down to the place where "train" is called and make the following changes: 
	
	path_to_folder= path to the directory where you saved the .npy files in the image generation code.
	
	name_image_train='<name of the image file .npy>'
	
	name_mask_train='<name of the mask file .npy>'
	
	path_to_save_model=<give a suitable path to save the model with the name of the name of the 	file with the extension .hdf5>
	
	height=512    #height of the image default set to 512 
	width=512     #width of the image default set to 512
	channel=1     #channels of the image default is set to 1

	feature_factor=64   #deciding factors on number of features
	number_of_layers=6  # choose between 10 and 6
	
	batch_size=2        # batch size for training. can be experimented with.
	epochs=5            #number of epochs for training. 100 epochs give great results could be  	increased 	to 200 or 300 for better results.
	
	learning_rate=5e-4  #learning rate for learning. default 5e-4.

4. For the testing make the following changes :
	
	path_to_testdata=   <give the path to the test file that you generated in the previous code including 	the file and not just the folder>
	path_to_outputfolder=        <give a desired location to save the predicted output>
	model=                        name of the model that was trained
	COLOR_DICT=                   colour dictionary which is already given for different classes.
	image_height=512,             #height of the image. default set to 512
	image_width=512,              #width of the image. default set to 512
	image_channel=1               #number of channels of the image. default set to 1
	batch_size=15                 #batch size for testing. default set to 15
