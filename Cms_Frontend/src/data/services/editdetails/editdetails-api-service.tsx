import HttpClientWrapper from "../../api/http-client-wrapper";

class EditDetailsApiService {

  private httpClientWrapper: HttpClientWrapper;

  constructor() {
    this.httpClientWrapper = new HttpClientWrapper();
  }

  updateCustomer = async (
    detailsDTOList: string,
    cmsId: number,
    euid: number,
    documentfiles: File[],
    pathId: number,
    imgName: string,
    includeImageRequest: boolean,
  ) => {
    try {
      const queryParams = `?DetailsDTOList=${encodeURIComponent(detailsDTOList)}&cmsId=${cmsId}&euid=${euid}&pathId=${pathId}&imgName=${encodeURIComponent(imgName)}&includeImageRequest=${includeImageRequest}`;
      const formData = new FormData();
      documentfiles.forEach(file => formData.append('documentfiles', file));
      const response = await this.httpClientWrapper.pute(`/api/v1/DetailSave/UpdateDetails${queryParams}`, formData);
      return response.data;
    } catch (error) {
      console.error("EditDetailsApiService updateCustomer() error:", error);
      throw error;
    }
  };

  fetchData = async (cmsId: number, pathId: number) => {
    try {
      const response = await this.httpClientWrapper.get(`/api/v1/GetDocumentType?cmsId=${cmsId}&pathId=${pathId}`);
      return response;
    } catch (error) {
      throw error;
    }
  };

  getFormDataHeaderConfig() {
    return this.httpClientWrapper.getHeaderConfig('multipart/form-data');
  };

}

export default EditDetailsApiService;