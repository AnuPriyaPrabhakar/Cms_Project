import React, { useEffect, useRef, useState } from 'react';
import { Container, Box, Grid, Table, TableBody, TableHead, TableCell, TableContainer, TableRow, Paper, Typography } from '@mui/material';
import { List, ListItem, ListItemText, ListItemIcon, Collapse } from '@mui/material';
import { AccountCircle, Group, People, Business, AttachMoney, Description } from '@mui/icons-material';
import { Button, Modal } from 'react-bootstrap';
import { useLocation, useNavigate, useParams } from 'react-router-dom';
import AssociatedlistPayload from '../../data/services/insert/dto/AssociatedlistPayload';
import AddressApiService from '../../data/services/insert/address-api-service';
import { Form, Card, Col, Row, Image } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUserCircle, faUniversity, faRecordVinyl, faRegistered, faFile, faUsers, faMobile, faUser, faFlag, faVenus, faMars, faSkull, faBuilding, faAddressCard, faHandshake, faIdCard, faBirthdayCake, faSync, faCalendarAlt, faGlobe, faMapMarker, faInfoCircle, faUserTie, faIndustry, faChild, faExternalLinkAlt, faBusinessTime, faList, faHome, faRing, faGraduationCap, faPerson, faBalanceScale, faPhone, faMailBulk, faCertificate, faCalendar, faTimes } from '@fortawesome/free-solid-svg-icons';
import Header from '../../layouts/header/header';
import profile from '../../assets/Avatar.png';
import jsPDF, { jsPDFOptions } from 'jspdf';
import 'jspdf-autotable';
import { renderToString } from 'react-dom/server';
import html2canvas from 'html2canvas';
import { State, bank, createDetailsRequest, Regulator, RegulatorListData, AliasesNameRequest, Gender, BirthDataRequest, PlaceofBirthRequest, RecordTypeData, Dead, DateofBirthRequest, RelativePayload, InorgPayload, CustomerRequest, AliasesDTO, AddressDTO, DateOfBirthDTO, DetailsCombineDTO, CreateCountryRegistrationRequest, IdNumberData, CountryHqData, Country, CreateCaseDetailsRequest, createBankDetailsRequests, createCompanyDetailsRequests, createIndPositionsRequests, createIndCaseDetailsRequests, ContactDetailsData, RelativeConfigData, CompanyPayload } from '../../data/services/Search/search-payload';
import SearchService from '../../data/services/Search/search-api-service';
import { useSelector } from 'react-redux';
import CountryApiService from '../../data/services/master/Country/country_api_service';
import IdNumberApiService from '../../data/services/master/IdNumber/idnumber_api_service';
import CustomerApiService from '../../data/services/customerEdit/customeredit_api_service';
import ViewPageDetailsService from '../../data/services/viewpage/viewpagedetails-api-service';
import { CustomerEditData } from '../CustomerEdit/Customeredit_payload';
import avatarImage from '../../../src/assets/Avatar.png';
import RelativeApiService from '../../data/services/master/relative/relative-api-serivces';

interface CompanyItem {
    companyDTO: {
        listAdverseInformation: number | string;
        listRegulatoryAction: number | string;
        listGovernment: number | string;
    };
};

interface CustomerData {
    createdAt?: string;
};

interface Party {
    id: string;
    partyMasterId: String;
    partyName: string;
};

interface CompanyDetailsItem {
    companyDTO: {
        id: number;
        sourceLink: string;
        associateMasterId: number;
        companyName: string;
        listAdverseInformation: number;
        listRegulatoryAction: number;
        listGovernment: number;
        originalDateOfAppointment: string;
        typeId: number;
        cinfcrn: string;
        document: string;
    },
    addressDTOS: Array<{
        id: number;
        companyId: number;
        registeredAddress: string;
    }>;
    contactDTOS: Array<{
        companyId: number;
        emailID: string;
    }>;
    companiesDirectorsDTOS: Array<{
        id: number;
        din: string;
        companyId: number;
        directorId: number;
        designationId: number;
        companyMasterId: number;
        appointmentDate: string;
        cessationDate: string;
        designation: string;
        directorStatus: string;
        directorName: string;
    }>;
    companyDocumentsDTOS: Array<{
        companyId: number;
        documentTypeId: number;
        documentType: string;
        imageName3: string;
        uid: number;
        files3: string[];
        path: number[];
        euid: number;
    }>;
}

const ManagerIndividualview: React.FC = () => {

    const userDetails = useSelector((state: any) => state.loginReducer);
    const loginDetails = userDetails.loginDetails
    const [Regulator, setRegulator] = useState<Regulator[]>([]);
    const [Regulatorlist, setRegulatorlist] = useState<RegulatorListData[]>([]);
    const [RecordType, setRecordType] = useState<RecordTypeData[]>([
    ]);
    const [bank, setbank] = useState<bank[]>([]);
    const [state, setstate] = useState<State[]>([]);
    const tableRef = useRef(null);
    const componentRef = useRef<HTMLDivElement | null>(null);
    const [selectedRecordType, setSelectedRecordType] = useState<string>('');
    const [isFileSelected, setIsFileSelected] = useState<boolean>(false);
    const [Dead, setDead] = useState<Dead[]>([]);
    const [Idnumber, setIdnumber] = useState<IdNumberData[]>([]);
    const [contact, setcontactDetails] = useState<ContactDetailsData[]>([]);
    const [relative, setRelative] = useState<RelativeConfigData[]>([]);
    const [CountryHqData, setCountryHqData] = useState<CountryHqData[]>([]);
    const [Country, setCountry] = useState<Country[]>([]);
    const [gender, setgender] = useState<Gender[]>([]);
    const deadRef = useRef<HTMLInputElement | null>(null);
    const genderRef = useRef<HTMLInputElement | null>(null);
    const [caseDetails, setCaseDetails] = useState<CreateCaseDetailsRequest[]>([{ cmsId: 0, recordTypeId: 0, caseDetails: '', uid: loginDetails.id }]);
    const [AliasesData, setAliasesData] = useState<AliasesDTO[]>([{ cmsId: 0, recordTypeId: 0, aliasesName: '', uid: loginDetails.id, }]);

    const [PartyformData, setPartyFormData] = useState<DateOfBirthDTO[]>([
        {
            cmsId: 0, recordTypeId: 0, dob: '', birthYearAlone: '', placeOfBirth: '', uid: loginDetails.id,
        },
    ]);

    const [showBankDetails, setShowBankDetails] = useState(false);
    const [showCompanyDetails, setShowCompanyDetails] = useState(false);
    const [Address, setAddress] = useState<AddressDTO[]>([{ cmsId: 0, recordTypeId: 0, address: '', uid: loginDetails.id, }]);
    const [showCountryDetails, setShowCountryDetails] = useState(false);
    const [showIndividualDetails, setShowIndividualDetails] = useState(false);

    const detailsCombine: DetailsCombineDTO = {
        addressDTOS: Address,
        dateOfBirthDTOS: PartyformData,
        aliasesDTOS: AliasesData
    };

    const countryService = new CountryApiService();
    const recordtype = new SearchService();
    const idnumberService = new IdNumberApiService();

    const getCountryNameById = (countryId: string) => {
        const country = Country.find((c) => String(c.id) === countryId);
        return country ? country.name : 'Not Available';
    };

    const getCountryHqDataById = (countryHqId: string) => {
        const country = CountryHqData.find((c) => String(c.id) === countryHqId);
        return country ? country.name : 'Not Available';
    };

    const getBank = (bankId: string) => {
        const foundBank = bank.find((c) => String(c.id) === bankId);
        return foundBank ? foundBank.bankName : 'Not Available';
    };

    const getstate = (stateId: string) => {
        const foundState = state.find((c) => String(c.id) === stateId);
        return foundState ? foundState.stateName : 'Not Available';
    };

    const getidentificationNumberIdaById = (identificationNumberId: string) => {
        const country = Idnumber.find((c) => String(c.id) === identificationNumberId);
        return country ? country.name : 'Not Available';
    };

    const getContactDetailsById = (contactId: string) => {
        const country = contact.find((c) => String(c.id) === contactId);
        return country ? country.name : 'Not Available';
    };

    const getRelativeById = (relativeMasterId: string) => {
        const country = relative.find((c) => String(c.id) === relativeMasterId);
        return country ? country.name : 'Not Available';
    };

    const fetchCountry = async () => {
        try {
            const country = await countryService.getCountryOptions();
            setCountry(country);
        }
        catch (error) {
            console.error("Error fetching associated list:", error);
        }
    };

    const fetchCountryHqData = async () => {
        try {
            const recordtypes = await recordtype.getCountryHq();
            setCountryHqData(recordtypes);
        }
        catch (error) {
            console.error("Error fetching associated list:", error);
        }
    };

    const fetchBank = async () => {
        try {
            const recordtypes = await recordtype.getBank();
            setbank(recordtypes);
        }
        catch (error) {
            console.error("Error fetching associated list:", error);
        }
    };

    const fetchSatete = async () => {
        try {
            const recordtypes = await recordtype.getState();
            setstate(recordtypes);
        }
        catch (error) {
            console.error("Error fetching associated list:", error);
        }
    };

    const fetchIdnumber = async () => {
        try {
            const idnumber = await idnumberService.getIdnumber();
            setIdnumber(idnumber);
        } catch (error) {
            console.error("Error fetching dead:", error);
        }
    };

    const fetchContactDetails = async () => {
        try {
            const recordtypes = await recordtype.getContactDetails();
            setcontactDetails(recordtypes);
        }
        catch (error) {
            console.error("Error fetching contact details:", error);
        }
    };

    const relatives = new RelativeApiService();

    const fetchRelative = async () => {
        try {
            const relativeData = await relatives.getRelative();
            setRelative(relativeData);
        }
        catch (error) {
            console.error("Error fetching associated list:", error);
        }
    };

    useEffect(() => {
        fetchCountry();
        fetchCountryHqData();
        fetchIdnumber();
        fetchBank();
        fetchSatete();
        fetchContactDetails();
        fetchRelative();
    }, []);

    const [DetailsData, setDetailsData] = useState<createDetailsRequest>({
        recordTypeId: 0,
        regulatorListId: 0,
        regulatorId: 0,
        display: 0,
        sourceLink: '',
        name: '',
        registrationNum: '',
        genderId: 0,
        deadId: 0,
        uid: loginDetails.id,
    });

    const [indOrgformData, setindOrgFormData] = useState<InorgPayload>({
        indOrgCommonDTO: [
            {
                positionsDTO: {
                    cmsId: 0,
                    recordTypeId: 0,
                    position: '',
                    linIndName: '',
                },
                indAliasesNameDTOS: [
                    {
                        cmsId: 0,
                        recordTypeId: 0,
                        positionId: 0,
                        linIndAliasesName: '',
                    },
                ],
                relationDTOS: [
                    {
                        cmsId: 0,
                        recordTypeId: 0,
                        positionId: 0,
                        relativeMasterId: 0,
                        relationship: '',
                    },
                ],
                relationAliasesDTOS: [
                    {
                        cmsId: 0,
                        recordTypeId: 0,
                        positionId: 0,
                        relationAliasesName: '',
                    },
                ],
                detailsAboutRelationDTOS: [
                    {
                        cmsId: 0,
                        recordTypeId: 0,
                        positionId: 0,
                        detailsAboutRelation: '',
                    },
                ],
            },
        ],
    });

    const { cmsId, uid, recordTypeId, positionId } = useParams();
    const [isHovered, setIsHovered] = useState(false);

    const tableStyle = {
        fontFamily: 'Times New Roman',
        fontWeight: 'bold',
    };

    const handleMouseOver = () => {
        setIsHovered(true);
    };

    const handleMouseOut = () => {
        setIsHovered(false);
    };

    const buttonStyle = {
        backgroundColor: isHovered ? '#135688' : '#1976D2',
        color: '#fff',
    };

    const [serialNumber, setSerialNumber] = useState(1);
    const navigate = useNavigate();
    const [appendedData, setAppendedData] = useState<CustomerEditData[]>([]);

    const handleUpdateClick = async (cmsId: string, uid: string) => {
        try {
            const statusCall = 'ManagerApprove';
            await viewPageDetailsService.updateManagerApprove(cmsId, uid, statusCall);
            const storedData = localStorage.getItem('customerData');
            if (storedData) {
                const transformedData = JSON.parse(storedData) as CustomerEditData[];
                setAppendedData((prevData) => {
                    const updatedData = [...prevData, ...transformedData];
                    return updatedData;
                });
                const hiddenPepIdsString = localStorage.getItem('hiddenPepIds');
                const hiddenPepIds = hiddenPepIdsString ? JSON.parse(hiddenPepIdsString) : [];
                const updatedHiddenPepIds = [...hiddenPepIds, cmsId];
                localStorage.setItem('hiddenPepIds', JSON.stringify(updatedHiddenPepIds));
            }
            console.log('Entry updated successfully');
            navigate(`/Manager/${cmsId}`);
        } catch (error) {
            console.error('Error updating entry:', error);
        }
    };

    const [showModal, setShowModal] = useState(false);
    const [selectedImage, setSelectedImage] = useState<string | null>(null);

    const handleImageClick = (image: string) => {
        setSelectedImage(image);
        setShowModal(true);
    };

    const [zoomLevel, setZoomLevel] = useState<number>(1);

    const handleZoom = () => {
        setZoomLevel(zoomLevel === 1 ? 2 : 1);
    };

    const [adverseInformation, setAdverseInformation] = useState('');
    const [regulatoryAction, setRegulatoryAction] = useState('');
    const [isLoading, setIsLoading] = useState(true);

    const handleCloseClick = async (cmsId: string, uid: string) => {
        const statusCall = 'CloseManagerView';
        await viewPageDetailsService.updateManagerClose(cmsId, uid, statusCall);
        navigate('/Manager');
    };

    const viewPageDetailsService = new ViewPageDetailsService();
    const customer = new SearchService();

    useEffect(() => {
        const fetchCustomer = async (cmsId: string, uid: string) => {
            try {
                setIsLoading(true);
                const customerData = await customer.getCustomer(cmsId);
                if (customerData.createDetailsRequest) {
                    const {
                        recordTypeId,
                        regulatorListId,
                        regulatorId,
                        display,
                        sourceLink,
                        name,
                        registrationNum,
                        deadId,
                        genderId,
                    } = customerData.createDetailsRequest;
                    setDetailsData({
                        recordTypeId: recordTypeId || '',
                        regulatorListId: regulatorListId || '',
                        regulatorId: regulatorId || '',
                        display: display || '',
                        name: name || '',
                        sourceLink: sourceLink || '',
                        registrationNum: registrationNum || '',
                        deadId: deadId || '',
                        genderId: genderId || '',
                        uid: loginDetails.id,
                    });
                }
                if (customerData.detailsCombineDTO) {
                    const addressData = customerData.detailsCombineDTO[0].addressDTOS.map((address: { cmsId: any; }) => ({
                        ...address,
                        cmsId: address.cmsId || '',
                        recordTypeId: recordTypeId || '',
                        uid: loginDetails.id,
                    }));
                    setAddress(addressData);
                    const dateOfBirthData = customerData.detailsCombineDTO[0].dateOfBirthDTOS.map((dateOfBirth: any) => ({
                        ...dateOfBirth,
                        cmsId: dateOfBirth.cmsId || '',
                        recordTypeId: recordTypeId || '',
                        dob: dateOfBirth.dob || '',
                        birthYearAlone: dateOfBirth.birthYearAlone || '',
                        placeOfBirth: dateOfBirth.placeOfBirth || '',
                        uid: loginDetails.id,
                    }));
                    setPartyFormData(dateOfBirthData);
                    const aliasesData = customerData.detailsCombineDTO[0].aliasesDTOS.map((alias: { cmsId: any; }) => ({
                        ...alias,
                        cmsId: alias.cmsId || '',
                        recordTypeId: recordTypeId || '',
                        uid: loginDetails.id,
                    }));
                    setAliasesData(aliasesData);
                }
                if (customerData.countryRegistrationData) {
                    const countryRegistrationData = customerData.countryRegistrationData.map((country: { countryId: any; recordTypeId: any; cmsId: any; countryHqId: any; identificationNumberId: any; identificationNum: any; identificationDetails: any; }) => ({
                        countryId: country.countryId || '',
                        recordTypeId: country.recordTypeId || '',
                        cmsId: country.cmsId || '',
                        countryHqId: country.countryHqId || '',
                        identificationNumberId: country.identificationNumberId || '',
                        identificationNum: country.identificationNum || '',
                        identificationDetails: country.identificationDetails || '',
                    }));
                    setCountryFormData(countryRegistrationData);
                }
                if (customerData.caseDetailsData) {
                    const caseDetailsData = customerData.caseDetailsData.map((caseDetail: any) => ({
                        recordTypeId: caseDetail.recordTypeId || '',
                        cmsId: caseDetail.cmsId || '',
                        caseDetails: caseDetail.caseDetails || '',
                        uid: loginDetails.id
                    }));
                    setCaseDetails(caseDetailsData);
                }
                if (customerData.bankDetailsData) {
                    const bankDetailsData = customerData.bankDetailsData.map((data: { recordTypeId: any; cmsId: any; bankId: any; name: any; acc_no: any; }) => ({
                        recordTypeId: data.recordTypeId || '',
                        cmsId: data.cmsId || '',
                        bankId: data.bankId || '',
                        name: data.name || '',
                        acc_no: data.acc_no || '',
                    }));
                    setBankFormData(bankDetailsData)
                }
                // if (customerData.companyDetailsData) {
                //     const companyDetailsData = customerData.companyDetailsData.map((data: any) => ({
                //         recordTypeId: selectedRecordType,
                //         cmsId: data.cmsId,
                //         identificationNumberId: data.identificationNumberId,
                //         stateId: data.stateId,
                //         companyName: data.companyName,
                //         role: data.role,
                //         address: data.address,
                //         idDetails: data.idDetails,
                //         uid: loginDetails.id
                //     }));
                //     setCompanyFormData(companyDetailsData)
                // }
                if (customerData.companyCombineDTO) {
                    const companyformData = customerData.companyCombineDTO.map((item: any) => ({
                        companyDetailsDTOS: {
                            cmsId: item.companyDetailsDTOS.cmsId || '',
                            recordTypeId: selectedRecordType || '',
                            identificationNumberId: item.companyDetailsDTOS.identificationNumberId || '',
                            stateId: item.companyDetailsDTOS.stateId || '',
                            role: item.companyDetailsDTOS.role || '',
                            companyName: item.companyDetailsDTOS.companyName || '',
                            address: item.companyDetailsDTOS.address || '',
                            idDetails: item.companyDetailsDTOS.idDetails || '',
                            uid: loginDetails.id
                        },
                        companyAliasesDTOS: item.companyAliasesDTOS.map((companyAliases: any) => ({
                            cmsId: companyAliases.cmsId || '',
                            recordTypeId: selectedRecordType || '',
                            companyId: companyAliases.companyId || '',
                            aliasesName: companyAliases.aliasesName || '',
                            uid: loginDetails.id
                        }))
                    }));

                    setCompanyFormData({
                        ...companyformData, companyCombineDTO: companyformData

                    });
                };
                if (customerData.indPositionsData) {
                    const indPositionsData = customerData.indPositionsData.map((PositionsData: any) => ({
                        recordTypeId: PositionsData.selectedRecordType || '',
                        cmsId: PositionsData.cmsId || '',
                        position: PositionsData.position || '',
                        uid: loginDetails.id
                    }));
                    setPositionsData(indPositionsData);
                }
                if (customerData.indCaseDetailsData) {
                    const indCaseDetailsData = customerData.indCaseDetailsData.map((caseDetails: any) => ({
                        recordTypeId: caseDetails.selectedRecordType || '',
                        cmsId: caseDetails.cmsId || '',
                        caseDetails: caseDetails.caseDetails || '',
                        uid: loginDetails.id
                    }));
                    setcaseData(indCaseDetailsData);
                }
                if (customerData.indOrgCommonDTO) {
                    const indOrgCommonData = customerData.indOrgCommonDTO.map((item: any) => ({
                        positionsDTO: {
                            cmsId: item.positionsDTO.cmsId || '',
                            recordTypeId: selectedRecordType || '',
                            position: item.positionsDTO.position || '',
                            linIndName: item.positionsDTO.linIndName || '',
                        },
                        indAliasesNameDTOS: item.indAliasesNameDTOS.map((alias: any) => ({
                            cmsId: alias.cmsId || '',
                            recordTypeId: selectedRecordType || '',
                            positionId: alias.positionId || '',
                            linIndAliasesName: alias.linIndAliasesName || '',
                        })),
                        relationDTOS: item.relationDTOS.map((relation: any) => ({
                            cmsId: relation.cmsId || '',
                            recordTypeId: selectedRecordType || '',
                            positionId: relation.positionId || '',
                            relationship: relation.relationship || '',
                        })),
                        relationAliasesDTOS: item.relationAliasesDTOS.map((relationAlias: any) => ({
                            cmsId: relationAlias.cmsId || '',
                            recordTypeId: selectedRecordType || '',
                            positionId: relationAlias.positionId || '',
                            relationAliasesName: relationAlias.relationAliasesName || '',
                        })),
                        detailsAboutRelationDTOS: item.detailsAboutRelationDTOS.map((details: any) => ({
                            cmsId: details.cmsId || '',
                            recordTypeId: selectedRecordType || '',
                            positionId: details.positionId || '',
                            detailsAboutRelation: details.detailsAboutRelation || '',
                        })),
                    }));
                    setindOrgFormData({ ...indOrgformData, indOrgCommonDTO: indOrgCommonData });
                }
                if (customerData.createDetailsRequest) {
                    await customer.updateManagerView(cmsId, uid, 'ManagerView');
                }
            } catch (error) {
                console.error('Error fetching customer:', error);
            } finally {
                setIsLoading(false);
            }
        };
        if (cmsId && uid) {
            fetchCustomer(cmsId, uid);
        }
        window.scrollTo(0, 0);
    }, [cmsId, uid],);

    function getgenderdeadId(deadId: number) {
        switch (deadId) {
            case 1:
                return 'Yes';
            case 2:
                return 'No';
        }
    };

    function getgenderrecoredtype(recordTypeId: number) {
        switch (recordTypeId) {
            case 1:
                return 'Entity';
            case 2:
                return 'Individual';
            case 3:
                return 'Ship';
            case 4:
                return 'Aircraft';
        }
    };

    function getgenderregulatorId(regulatorId: number) {
        switch (regulatorId) {
            case 1:
                return 'Yes';
            case 2:
                return 'No';
        }
    };

    function getgenderregulatorListId(regulatorListId: number) {
        switch (regulatorListId) {
            case 1:
                return 'Yes';
            case 2:
                return 'No';
        }
    };

    function getAssociatedName(associateMasterdId: number) {
        switch (associateMasterdId) {
            case 1:
                return 'Private';
            case 2:
                return 'LLP';
            default:
                return 'Unknown';
        }
    };

    function getgenderName(genderId: number) {
        switch (genderId) {
            case 1:
                return 'Male';
            case 2:
                return 'FeMale';
            case 3:
                return 'Others';
        }
    };

    function getDesignationName(associateMasterdId: number) {
        switch (associateMasterdId) {
            case 1:
                return 'Designer';
            case 2:
                return 'HR';
            case 3:
                return 'Manager';
            case 4:
                return 'Civil Engineer';
            default:
                return 'Not Available';
        }
    };

    const [countryformData, setCountryFormData] = useState<CreateCountryRegistrationRequest[]>([
        {
            countryId: 0,
            recordTypeId: 0,
            cmsId: 0,
            countryHqId: 0,
            identificationNumberId: 0,
            identificationNum: '',
            identificationDetails: '',
            contactId: 0,
            contactName: '',
        }
    ]);

    const [BankformData, setBankFormData] = useState<createBankDetailsRequests[]>([
        {
            bankId: 0,
            recordTypeId: 0,
            cmsId: 0,
            acc_no: '',
            name: '',
            uid: loginDetails.id,
        }
    ]);

    const [companyformData, setCompanyFormData] = useState<CompanyPayload>({
        companyCombineDTO: [
            {
                companyDetailsDTOS: {
                    cmsId: 0,
                    recordTypeId: 0,
                    identificationNumberId: '',
                    stateId: 0,
                    role: '',
                    companyName: '',
                    address: '',
                    idDetails: '',
                },
                companyAliasesDTOS: [
                    {
                        cmsId: 0,
                        recordTypeId: 0,
                        companyId: 0,
                        aliasesName: '',
                    },
                ],
            },
        ],
    });

    const [PositionsData, setPositionsData] = useState<createIndPositionsRequests[]>([{ cmsId: 0, recordTypeId: 0, position: '', uid: loginDetails.id, }]);
    const [caseData, setcaseData] = useState<createIndCaseDetailsRequests[]>([{ cmsId: 0, recordTypeId: 0, caseDetails: '', uid: loginDetails.id, }]);
    const [base64Image, setBase64Image] = useState<string | null>(null);

    const [pdfData, setPdfData] = useState<{ base64: string | null; filename: string | null }>({
        base64: null,
        filename: null,
    });

    const [documentTypes, setDocumentTypes] = useState<string[]>([]);
    const [directorDocumentType, setDirectorDocumentTypes] = useState<string[]>([]);
    const [selectedDocumentType, setSelectedDocumentType] = useState<string | null>(null);
    const [imageSrc, setImageSrc] = useState<string | null>(null);
    const [bussinessImage, setBussinessImageSrc] = useState<string | null>(null);
    const [imageSource, setImageSource] = useState<string | null>(null);

    const [companyDetails, setCompanyDetails] = useState({
        cmsId: 0,
        documentType: ''
    });

    const headingStyle = {
        fontFamily: 'Times New Roman',
        fontSize: '20px',
    };

    const nameStyle = {
        fontFamily: 'Times New Roman',
        fontSize: '25px',
        fontWeight: 'bold',
        margin: '0',
    };

    function formatDateInMonth(datesString: string | number | Date) {
        const months = [
            'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
            'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'
        ];
        const date = new Date(datesString);
        const day = date.getDate();
        const month = months[date.getMonth()];
        const year = date.getFullYear();
        return `${day} ${month} ${year}`;
    };

    const [partylist, setPartylist] = useState<{ id: string; partyName: string }[]>([]);

    const mapPartyIdToName = (partyId: string | number) => {
        const idToFindString = typeof partyId === 'number' ? partyId.toString() : partyId;
        const party = partylist.find((party) => party.id == idToFindString);
        return party ? party.partyName : 'Not Available';
    };

    const [error, setError] = useState<string | null>(null);
    const [loading, setLoading] = useState(false);
    const [profileImageData, setProfileImageData] = useState<string | null>(null);
    const customerApiService = new CustomerApiService();

    const handleButtonClick = async (cmsId: number, pathId: number, fileType: string) => {
        // try {
        //     const imageData = await customerApiService.getImage(pathId, cmsId);
        //     const base64String = arrayBufferToBase64(imageData);
        //     setBase64Image(base64String);
        // } catch (error) {
        //     console.error('Error fetching image:', error);
        // }
        try {
            if (fileType === 'image') {
                const imageData = await customerApiService.getImage(pathId, cmsId);
                const base64String = arrayBufferToBase64(imageData);
                setBase64Image(base64String);
            } else if (fileType === 'pdf') {
                const pdfData = await customerApiService.getPDF(pathId, cmsId);
                setPdfData({ base64: pdfData.data, filename: pdfData.filename });
            }
        } catch (error) {
            console.error('Error fetching file:', error);
        }
    };

    const arrayBufferToBase64 = (buffer: ArrayBuffer): string => {
        const binary = new Uint8Array(buffer);
        const bytes = [];
        for (let i = 0; i < binary.length; i++) {
            bytes.push(String.fromCharCode(binary[i]));
        }
        const base64String = btoa(bytes.join(''));
        return `data:image/png;base64,${base64String}`;
    };

    useEffect(() => {
        handleButtonClick(parseInt(cmsId || '0', 10), 2, 'image');
        handleButtonClick(parseInt(cmsId || '0', 10), 2, 'pdf');

    }, []);

    const backendColumns = ['RecordType', 'Source Link', 'Regulator', 'RegulatorList', 'Name', 'Aliases Name', 'Gender', 'Date of Birth', 'BirthYearAlone', 'Place of Birth', 'Dead', 'Address', 'Country Details', 'Individual Details', 'Case Details', 'Positions Detail', 'Case Detail', "Bank Details", 'Company Details'];

    const getColumnIcon = (columnName: string) => {
        switch (columnName) {
            case 'RecordType':
                return <FontAwesomeIcon icon={faRecordVinyl} />;
            case 'Source Link':
                return <FontAwesomeIcon icon={faExternalLinkAlt} />;
            case 'Regulator':
                return <FontAwesomeIcon icon={faRegistered} />;
            case 'RegulatorList':
                return <FontAwesomeIcon icon={faFile} />;
            case 'Name':
                return <FontAwesomeIcon icon={faUser} />;
            case 'Aliases Name':
                return <FontAwesomeIcon icon={faUser} />;
            case 'Gender':
                return (
                    <>
                        <FontAwesomeIcon icon={faVenus} title="Female" />
                        <FontAwesomeIcon icon={faMars} title="Male" />
                    </>
                );
            case 'Date of Birth':
                return <FontAwesomeIcon icon={faBirthdayCake} />;
            case 'BirthYearAlone':
                return <FontAwesomeIcon icon={faCalendar} />;
            case 'Place of Birth':
                return <FontAwesomeIcon icon={faMapMarker} />;
            case 'Dead':
                return <FontAwesomeIcon icon={faCertificate} />;
            case 'Address':
                return <FontAwesomeIcon icon={faAddressCard} />
            case 'Country Details':
                return <FontAwesomeIcon icon={faFlag} />
            case 'Individual Details':
                return <FontAwesomeIcon icon={faPerson} />
            case 'Case Details':
                return <FontAwesomeIcon icon={faBalanceScale} />
            case 'Positions Detail':
                return <FontAwesomeIcon icon={faPerson} />
            case 'Case Detail':
                return <FontAwesomeIcon icon={faBalanceScale} />
            case 'Bank Details':
                return <FontAwesomeIcon icon={faUniversity} />
            case 'Company Details':
                return <FontAwesomeIcon icon={faBuilding} />
            default:
                return null;
        }
    };

    const formatDate = (dateString: string | number | Date) => {
        if (!dateString) {
            return 'Not Available';
        }
        const date = new Date(dateString);
        const day = date.getDate().toString().padStart(2, '0');
        const monthNames = ['JAN', 'FEB', 'MAR', 'APR', 'MAY', 'JUN', 'JUL', 'AUG', 'SEP', 'OCT', 'NOV', 'DEC'];
        const month = monthNames[date.getMonth()];
        const year = date.getFullYear();
        return `${day}-${month}-${year}`;
    };

    const renderTableRows = () => {
        return backendColumns.map((columnName, index) => (
            <TableRow key={columnName} style={{ height: '30px' }}>
                <TableCell>
                    <div style={{ display: 'flex', alignItems: 'center', lineHeight: '1' }}>
                        <span style={{ marginRight: '10px' }}>{getColumnIcon(columnName)}</span>
                        <Typography variant="body1" fontWeight="bold" style={{ marginLeft: '3px', lineHeight: '1' }}>
                            {columnName}
                        </Typography>
                    </div>
                </TableCell>
                <TableCell>
                    <div style={{ marginLeft: '20px' }}>
                        {renderColumnValue(columnName, DetailsData, PartyformData)}
                    </div>
                </TableCell>
            </TableRow>
        ));
    };

    const [showFullText, setShowFullText] = useState(false);

    const toggleText = () => {
        setShowFullText(!showFullText);
    };

    const MAX_LENGTH = 100;
    const [selectedCompanyName, setSelectedCompanyName] = useState("");

    const renderColumnValue = (columnName: string, DetailsData: any, PartyformData: any) => {
        switch (columnName) {
            case 'RecordType':
                return getgenderrecoredtype(DetailsData.recordTypeId) || 'Not Available';
            case 'Source Link':
                const sourceLink = DetailsData.sourceLink;
                const maxLinkLength = 50;
                return (
                    <div>
                        {sourceLink ? (
                            sourceLink.split('\n').map((link: string, index: number) => (
                                <React.Fragment key={index}>
                                    <p style={{ marginBottom: '-14px', maxWidth: '100%' }}>
                                        <a href={link} target="_blank" rel="noopener noreferrer" style={{ display: 'inline-block', maxWidth: '100%', overflow: 'hidden', textOverflow: 'ellipsis', whiteSpace: 'nowrap' }}>
                                            {link.length > maxLinkLength ? `${link.substring(0, maxLinkLength)}...` : link}
                                        </a>
                                    </p>
                                    {index < sourceLink.split('\n').length - 1 && <br />}
                                </React.Fragment>
                            ))
                        ) : (
                            <p style={{ marginBottom: '5px' }}>Not Available</p>
                        )}
                    </div>
                );
            case 'Regulator':
                return getgenderregulatorId(DetailsData.regulatorId) || 'Not Available';
            case 'RegulatorList':
                return getgenderregulatorListId(DetailsData.recoredtypelist) || 'Not Available';
            case 'Name':
                return DetailsData.name || 'Not Available';
            // case 'Aliases Name':
            //     return (AliasesData.length > 0 && AliasesData[0].aliasesName && AliasesData[0].aliasesName.trim() !== '')
            //         ? AliasesData[0].aliasesName
            //         : 'Not Available';
            case 'Aliases Name':
                if (AliasesData.length > 0) {
                    const aliasesElements = AliasesData.map((item, index) => (
                        <p key={index}>{item.aliasesName.trim()}</p>
                    ));
                    return <div>{aliasesElements}</div>;
                } else {
                    return <p>Not Available</p>;
                }
            case 'Gender':
                return getgenderName(DetailsData.genderId) || 'Not Available';
            case 'Date of Birth':
                if (PartyformData && PartyformData.length > 0) {
                    const dobDate = new Date(PartyformData[0].dob);
                    const monthNames = ['JAN', 'FEB', 'MAR', 'APR', 'MAY', 'JUN', 'JUL', 'AUG', 'SEP', 'OCT', 'NOV', 'DEC'];
                    const day = dobDate.getDate();
                    const month = monthNames[dobDate.getMonth()];
                    const year = dobDate.getFullYear();
                    const formattedDate = `${day}-${month}-${year}`;
                    return formattedDate;
                } else {
                    return 'Not Available';
                }
            case 'BirthYearAlone':
                return PartyformData && PartyformData.length > 0 ? PartyformData[0].birthYearAlone || 'Not Available' : 'Not Available';
            case 'Place of Birth':
                return PartyformData && PartyformData.length > 0 ? PartyformData[0].placeOfBirth || 'Not Available' : 'Not Available';
            case 'Dead':
                return getgenderdeadId(DetailsData.deadId) || 'Not Available';
            // case 'Address':
            //     return (Address.length > 0 && Address[0].address && Address[0].address.trim() !== '')
            //         ? Address[0].address
            //         : 'Not Available';
            case 'Address':
                if (Address && Address.length > 0) {
                    const addressElements = Address.map((item, index) => {
                        const lines = item.address.trim().split('\n');
                        return (
                            <div key={index}>
                                {lines.map((line, lineIndex) => (
                                    <React.Fragment key={lineIndex}>
                                        {line}
                                        {lineIndex < lines.length - 1 && <br />}
                                    </React.Fragment>
                                ))}
                            </div>
                        );
                    });
                    return <div>{addressElements}</div>;
                } else {
                    return <p>Not Available</p>;
                }
            case 'Country Details':
                return (
                    <div>
                        {countryformData && countryformData.length > 0 ? (
                            <>
                                {showCountryDetails ? null : (
                                    <Typography
                                        component="span"
                                        style={{ cursor: 'pointer', color: 'rgba(var(--bs-link-color-rgb),var(--bs-link-opacity,1))', textDecoration: 'underline' }}
                                        onClick={() => setShowCountryDetails(!showCountryDetails)}
                                    >
                                        Show More Details
                                    </Typography>
                                )}
                                <Collapse in={showCountryDetails}>
                                    <div>
                                        {countryformData && countryformData.length > 0 ? (
                                            <>
                                                <Grid item xs={12} sm={12}>
                                                    <TableContainer component={Paper} style={{ width: '100%', marginTop: '1%' }}>
                                                        <Table>
                                                            <TableHead>
                                                                <TableRow>
                                                                    <TableCell ><strong>Country</strong></TableCell>
                                                                    <TableCell ><strong>Country of Head Quarters</strong></TableCell>
                                                                    <TableCell ><strong>National Identification</strong></TableCell>
                                                                    <TableCell ><strong>Identification Number</strong></TableCell>
                                                                    <TableCell ><strong>Identification Details</strong></TableCell>
                                                                    <TableCell ><strong>Contact</strong></TableCell>
                                                                    <TableCell ><strong>Contact Name</strong></TableCell>
                                                                </TableRow>
                                                            </TableHead>
                                                            <TableBody>
                                                                {isLoading ? (
                                                                    <TableRow>
                                                                        <TableCell colSpan={4}>Loading...</TableCell>
                                                                    </TableRow>
                                                                ) : countryformData && countryformData.length > 0 ? (
                                                                    countryformData.map((country, index) => (
                                                                        <TableRow key={index}>
                                                                            <TableCell>
                                                                                <p style={headingStyle}>{getCountryNameById(country.countryId.toString())}</p>
                                                                            </TableCell>
                                                                            <TableCell>
                                                                                <p style={headingStyle}>{getCountryHqDataById(country.countryHqId.toString())}</p>
                                                                            </TableCell>
                                                                            <TableCell>
                                                                                <p style={headingStyle}>{getidentificationNumberIdaById(country.identificationNumberId.toString())}</p>
                                                                            </TableCell>
                                                                            <TableCell>{country.identificationNum.trim() !== '' ? country.identificationNum : 'Not Available'}</TableCell>
                                                                            <TableCell>{country.identificationDetails.trim() !== '' ? country.identificationDetails : 'Not Available'}</TableCell>
                                                                            <TableCell>
                                                                                <p style={headingStyle}>
                                                                                    {country.contactId && getContactDetailsById(country.contactId.toString())}
                                                                                </p>
                                                                            </TableCell>
                                                                            <TableCell>
                                                                                {country.contactName && country.contactName.trim() !== '' ? country.contactName : 'Not Available'}
                                                                            </TableCell>
                                                                        </TableRow>
                                                                    ))
                                                                ) : (
                                                                    <TableRow>
                                                                        <TableCell colSpan={4}>No data available</TableCell>
                                                                    </TableRow>
                                                                )}

                                                            </TableBody>
                                                        </Table>
                                                    </TableContainer>
                                                </Grid>
                                            </>
                                        ) : (
                                            <TableRow>
                                                <TableCell colSpan={6}>No data available</TableCell>
                                            </TableRow>
                                        )}
                                    </div>
                                </Collapse>
                            </>
                        ) : (
                            <p>Not Available</p>
                        )}
                        {showCountryDetails && (
                            <Typography
                                component="span"
                                style={{ cursor: 'pointer', color: 'rgba(var(--bs-link-color-rgb),var(--bs-link-opacity,1))', textDecoration: 'underline' }}
                                onClick={() => setShowCountryDetails(!showCountryDetails)}
                            >
                                Hide More Details
                            </Typography>
                        )}
                    </div>
                );
            case 'Individual Details':
                return (
                    <div>
                        {countryformData && countryformData.length > 0 ? (
                            <>
                                {showIndividualDetails ? null : (
                                    <Typography
                                        component="span"
                                        style={{ cursor: 'pointer', color: 'rgba(var(--bs-link-color-rgb),var(--bs-link-opacity,1))', textDecoration: 'underline' }}
                                        onClick={() => setShowIndividualDetails(!showIndividualDetails)}
                                    >
                                        Show More Details
                                    </Typography>
                                )}
                                <Collapse in={showIndividualDetails}>
                                    <div>
                                        {countryformData && countryformData.length > 0 ? (
                                            <>
                                                <Grid item xs={12} sm={12}>
                                                    <TableContainer component={Paper} style={{ width: '100%', marginBottom: '1%' }}>
                                                        <Table>
                                                            <TableHead>
                                                                <TableRow>
                                                                    <TableCell style={tableStyle}><strong>Position</strong></TableCell>
                                                                    <TableCell style={tableStyle}><strong>Linked Individuald Name</strong></TableCell>
                                                                    <TableCell style={tableStyle}><strong>Linked Individual Aliases Name</strong></TableCell>
                                                                    <TableCell style={tableStyle}><strong>Relationship</strong></TableCell>
                                                                    <TableCell style={tableStyle}><strong>Relationship Aliase sName</strong></TableCell>
                                                                    <TableCell style={tableStyle}><strong>Details About Relation</strong></TableCell>
                                                                </TableRow>
                                                            </TableHead>
                                                            <TableBody>
                                                                {indOrgformData.indOrgCommonDTO?.map((item, index) => (
                                                                    <TableRow key={index}>
                                                                        <TableCell>
                                                                            <p>{item.positionsDTO && item.positionsDTO.position ? item.positionsDTO.position : '_'}</p>
                                                                        </TableCell>
                                                                        <TableCell>
                                                                            <p>{item.positionsDTO && item.positionsDTO.linIndName ? item.positionsDTO.linIndName : '_'}</p>
                                                                        </TableCell>
                                                                        <TableCell>
                                                                            {item.indAliasesNameDTOS?.length > 0 ? (
                                                                                item.indAliasesNameDTOS.map((contact, contactIndex) => (
                                                                                    <p key={contactIndex}>{contact.linIndAliasesName || '_'}</p>
                                                                                ))
                                                                            ) : (
                                                                                <p>_</p>
                                                                            )}
                                                                        </TableCell>
                                                                        <TableCell>
                                                                            {item.relationDTOS?.length > 0 ? (
                                                                                item.relationDTOS.map((contact, contactIndex) => (
                                                                                    <p key={contactIndex}>{contact.relativeMasterId || '_'}</p>
                                                                                ))
                                                                            ) : (
                                                                                <p>_</p>
                                                                            )}
                                                                        </TableCell>
                                                                        <TableCell>
                                                                            {item.relationAliasesDTOS?.length > 0 ? (
                                                                                item.relationAliasesDTOS.map((contact, contactIndex) => (
                                                                                    <p key={contactIndex}>{contact.relationAliasesName || '_'}</p>
                                                                                ))
                                                                            ) : (
                                                                                <p>_</p>
                                                                            )}
                                                                        </TableCell>
                                                                        <TableCell>
                                                                            {item.detailsAboutRelationDTOS?.length > 0 ? (
                                                                                item.detailsAboutRelationDTOS.map((contact, contactIndex) => (
                                                                                    <p key={contactIndex}>{contact.detailsAboutRelation || '_'}</p>
                                                                                ))
                                                                            ) : (
                                                                                <p>_</p>
                                                                            )}
                                                                        </TableCell>
                                                                    </TableRow>
                                                                ))}
                                                            </TableBody>
                                                        </Table>
                                                    </TableContainer>
                                                </Grid>
                                            </>
                                        ) : (
                                            <TableRow>
                                                <TableCell colSpan={6}>No data available</TableCell>
                                            </TableRow>
                                        )}
                                    </div>
                                </Collapse>
                            </>
                        ) : (
                            <p>Not Available</p>
                        )}
                        {showIndividualDetails && (
                            <Typography
                                component="span"
                                style={{ cursor: 'pointer', color: 'rgba(var(--bs-link-color-rgb),var(--bs-link-opacity,1))', textDecoration: 'underline' }}
                                onClick={() => setShowIndividualDetails(!showIndividualDetails)}
                            >
                                Hide More Details
                            </Typography>
                        )}
                    </div>
                );
            case 'Case Details':
                return (
                    <>
                        {caseDetails.map((detail, index) => (
                            <Grid item xs={12} sm={3} key={index}>
                                {showFullText || detail.caseDetails.split('\n').map((line, lineIndex) => (
                                    <React.Fragment key={lineIndex}>
                                        {line}
                                        {lineIndex < detail.caseDetails.split('\n').length - 1 && <br />}
                                    </React.Fragment>
                                ))}
                                {detail.caseDetails.length > MAX_LENGTH && (
                                    <span onClick={toggleText} style={{ color: 'rgba(var(--bs-link-color-rgb),var(--bs-link-opacity,1))', cursor: 'pointer' }}>
                                        {showFullText ? ' Read More' : ' Read Less'}
                                    </span>
                                )}
                            </Grid>
                        ))}
                    </>
                );
                // return (
                //     <>
                //         {caseDetails.map((detail, index) => (
                //             <Grid item xs={12} sm={3} key={index}>
                //                 <p>
                //                     {showFullText || detail.caseDetails.length <= MAX_LENGTH
                //                         ? detail.caseDetails
                //                         : detail.caseDetails.slice(0, MAX_LENGTH) + '...'}
                //                     {detail.caseDetails.length > MAX_LENGTH && (
                //                         <span onClick={toggleText} style={{ color: 'rgba(var(--bs-link-color-rgb),var(--bs-link-opacity,1))', cursor: 'pointer' }}>
                //                             {showFullText ? ' Read Less' : ' Read More'}
                //                         </span>
                //                     )}
                //                 </p>
                //             </Grid>
                //         ))}
                //     </>
                // );
            case 'Positions Detail':
                return (
                    <>
                        {PositionsData.map((detail, index) => (
                            <Grid item xs={12} sm={3} key={index}>
                                <p>
                                    {showFullText || detail.position.length <= MAX_LENGTH
                                        ? detail.position
                                        : detail.position.slice(0, MAX_LENGTH) + '...'}
                                    {detail.position.length > MAX_LENGTH && (
                                        <span onClick={toggleText} style={{ color: 'rgba(var(--bs-link-color-rgb),var(--bs-link-opacity,1))', cursor: 'pointer' }}>
                                            {showFullText ? ' Read Less' : ' Read More'}
                                        </span>
                                    )}
                                </p>
                            </Grid>
                        ))}
                    </>
                );
            case 'Case Detail':
                return (
                    <>
                        {caseData.map((detail, index) => (
                            <Grid item xs={12} sm={3} key={index}>
                                <p>
                                    {showFullText || detail.caseDetails.length <= MAX_LENGTH
                                        ? detail.caseDetails
                                        : detail.caseDetails.slice(0, MAX_LENGTH) + '...'}
                                    {detail.caseDetails.length > MAX_LENGTH && (
                                        <span onClick={toggleText} style={{ color: 'rgba(var(--bs-link-color-rgb),var(--bs-link-opacity,1))', cursor: 'pointer' }}>
                                            {showFullText ? ' Read Less' : ' Read More'}
                                        </span>
                                    )}
                                </p>
                            </Grid>
                        ))}
                    </>
                );
            case 'Bank Details':
                return (
                    <div>
                        {BankformData && BankformData.length > 0 ? (
                            <>
                                {showBankDetails ? null : (
                                    <Typography
                                        component="span"
                                        style={{ cursor: 'pointer', color: 'rgba(var(--bs-link-color-rgb),var(--bs-link-opacity,1))', textDecoration: 'underline' }}
                                        onClick={() => setShowBankDetails(!showBankDetails)}
                                    >
                                        Show More Details
                                    </Typography>
                                )}
                                <Collapse in={showBankDetails}>
                                    <div>
                                        {BankformData && BankformData.length > 0 ? (
                                            <>
                                                <Grid item xs={12} sm={12}>
                                                    <TableContainer component={Paper} style={{ width: '100%', marginTop: '1%' }}>
                                                        <Table>
                                                            <TableHead>
                                                                <TableRow>
                                                                    <TableCell ><strong>Bank Name</strong></TableCell>
                                                                    <TableCell ><strong>Account Number</strong></TableCell>
                                                                    <TableCell ><strong>Name</strong></TableCell>
                                                                </TableRow>
                                                            </TableHead>
                                                            <TableBody>
                                                                {isLoading ? (
                                                                    <TableRow>
                                                                        <TableCell colSpan={4}>Loading...</TableCell>
                                                                    </TableRow>
                                                                ) : BankformData && BankformData.length > 0 ? (
                                                                    BankformData.map((bank, index) => (
                                                                        <TableRow key={index}>
                                                                            <TableCell>
                                                                                <p>{getBank(bank.bankId.toString())}</p>
                                                                            </TableCell>
                                                                            <TableCell>{bank.acc_no.trim() !== '' ? bank.acc_no : 'Not Available'}</TableCell>
                                                                            <TableCell>{bank.name.trim() !== '' ? bank.name : 'Not Available'}</TableCell>
                                                                        </TableRow>
                                                                    ))
                                                                ) : (
                                                                    <TableRow>
                                                                        <TableCell colSpan={4}>No data available</TableCell>
                                                                    </TableRow>
                                                                )}
                                                            </TableBody>
                                                        </Table>
                                                    </TableContainer>
                                                </Grid>
                                            </>
                                        ) : (
                                            <TableRow>
                                                <TableCell colSpan={6}>No data available</TableCell>
                                            </TableRow>
                                        )}
                                    </div>
                                </Collapse>
                            </>
                        ) : (
                            <p>Not Available</p>
                        )}
                        {showBankDetails && (
                            <Typography
                                component="span"
                                style={{ cursor: 'pointer', color: 'rgba(var(--bs-link-color-rgb),var(--bs-link-opacity,1))', textDecoration: 'underline' }}
                                onClick={() => setShowBankDetails(!showBankDetails)}
                            >
                                Hide More Details
                            </Typography>
                        )}
                    </div>
                );
            case 'Company Details':
                return (
                    <div>
                        {companyformData && companyformData.companyCombineDTO && companyformData.companyCombineDTO.length > 0 ? (
                            <>
                                {showCompanyDetails ? null : (
                                    <Typography
                                        component="span"
                                        style={{ cursor: 'pointer', color: 'rgba(var(--bs-link-color-rgb),var(--bs-link-opacity,1))', textDecoration: 'underline' }}
                                        onClick={() => setShowCompanyDetails(!showCompanyDetails)}
                                    >
                                        Show More Details
                                    </Typography>
                                )}
                                <Collapse in={showCompanyDetails}>
                                    <div>
                                        <TableContainer component={Paper} style={{ width: '100%', marginTop: '1%' }}>
                                            <Table>
                                                <TableHead>
                                                    <TableRow>
                                                        <TableCell><strong>Role</strong></TableCell>
                                                        <TableCell><strong>Company Name</strong></TableCell>
                                                        <TableCell><strong>Address</strong></TableCell>
                                                        <TableCell><strong>State</strong></TableCell>
                                                        <TableCell><strong>Identification</strong></TableCell>
                                                        <TableCell><strong>Id Details</strong></TableCell>
                                                        <TableCell><strong>Aliases Name</strong></TableCell>
                                                    </TableRow>
                                                </TableHead>
                                                <TableBody>
                                                    {companyformData.companyCombineDTO.map((company, index) => (
                                                        <TableRow key={index}>
                                                            <TableCell>{company.companyDetailsDTOS.role || 'Not Available'}</TableCell>
                                                            <TableCell>{company.companyDetailsDTOS.companyName || 'Not Available'}</TableCell>
                                                            <TableCell>{company.companyDetailsDTOS.address ? <div dangerouslySetInnerHTML={{ __html: company.companyDetailsDTOS.address.replace(/\n/g, '<br>') }} /> : 'Not Available'}</TableCell>
                                                            <TableCell>
                                                                <p>{getstate(company.companyDetailsDTOS.stateId.toString())}</p>
                                                            </TableCell>
                                                            <TableCell>
                                                                <p>{getidentificationNumberIdaById(company.companyDetailsDTOS.identificationNumberId.toString())}</p>
                                                            </TableCell>
                                                            <TableCell>{company.companyDetailsDTOS.idDetails || 'Not Available'}</TableCell>
                                                            <TableCell>
                                                                {company.companyAliasesDTOS.length > 0 ? (
                                                                    company.companyAliasesDTOS.map((alias, aliasIndex) => (
                                                                        <p key={aliasIndex}>{alias.aliasesName}</p>
                                                                    ))
                                                                ) : (
                                                                    'Not Available'
                                                                )}
                                                            </TableCell>
                                                        </TableRow>
                                                    ))}
                                                </TableBody>
                                            </Table>
                                        </TableContainer>
                                    </div>
                                </Collapse>
                            </>
                        ) : (
                            <p>Not Available</p>
                        )}
                        {showCompanyDetails && (
                            <Typography
                                component="span"
                                style={{ cursor: 'pointer', color: 'rgba(var(--bs-link-color-rgb),var(--bs-link-opacity,1))', textDecoration: 'underline' }}
                                onClick={() => setShowCompanyDetails(!showCompanyDetails)}
                            >
                                Hide More Details
                            </Typography>
                        )}
                    </div>
                );

        };
    }

    const renderPhoto = () => {
        return (
            <div>
                <Grid item xs={12}>
                    <React.Fragment>
                        <Col xs={1}>
                            <div onClick={() => handleButtonClick(parseInt(cmsId || '0', 10), 1, 'image')}>
                            </div>
                        </Col>
                        {base64Image && (
                            <Col xs={12} style={{ marginTop: '2%' }}>
                                <div>
                                    <h2>Image Preview</h2>
                                    <Image src={base64Image} alt="Preview" style={{ maxHeight: '100px', maxWidth: '300px', cursor: 'pointer' }} onClick={() => handleImageClick(base64Image)} />

                                </div>
                            </Col>
                        )}
                        {!base64Image && (
                            <Col xs={12} style={{ marginTop: '2%' }}>
                                <div>
                                    <h2>Default Image</h2>
                                    <img src={avatarImage} alt="Default Preview" style={{ maxHeight: '100px', maxWidth: '300px' }} />
                                </div>
                            </Col>
                        )}
                        <Modal show={showModal} onHide={() => setShowModal(false)} size="lg" centered style={{ backgroundColor: 'transparent' }}>
                            <Modal.Body style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', position: 'relative' }}>
                                {selectedImage && (
                                    <img
                                        src={selectedImage}
                                        alt="Preview"
                                        style={{
                                            maxWidth: '100%',
                                            maxHeight: '100%',
                                            cursor: 'pointer',
                                            transform: `scale(${zoomLevel})`,
                                            transition: 'transform 0.2s ease-in-out'
                                        }}
                                        onClick={(event) => {
                                            if (zoomLevel === 2) {
                                                event.preventDefault();
                                            } else {
                                                handleZoom();
                                            }
                                        }}
                                    />
                                )}
                                <FontAwesomeIcon icon={faTimes} style={{ position: 'absolute', top: '20px', right: '20px', cursor: 'pointer' }} onClick={() => setShowModal(false)} />
                            </Modal.Body>
                        </Modal>
                        {pdfData.base64 && (
                            <Col xs={12} style={{ marginTop: '2%' }}>
                                <div>
                                    <h2>PDF Preview</h2>
                                    <iframe
                                        title="PDF Preview"
                                        width="100%"
                                        height="100%"
                                        style={{ border: 'none' }}
                                        src={`data:application/pdf;base64,${pdfData.base64}`}
                                    />
                                    {pdfData.filename && (
                                        <div style={{ marginTop: '10px' }}>
                                            <a
                                                href={`data:application/pdf;base64,${pdfData.base64}`}
                                                download={pdfData.filename}
                                                target="_blank"
                                                rel="noopener noreferrer"
                                                style={{ textDecoration: 'none', padding: '10px', backgroundColor: '#2a75bb', color: 'white', borderRadius: '5px', cursor: 'pointer' }}
                                            >
                                                Download PDF
                                            </a>
                                        </div>
                                    )}
                                </div>
                            </Col>
                        )}
                    </React.Fragment>
                </Grid>
            </div>
        );
    };

    return (
        <div>
            <Box sx={{ display: 'flex' }}>
                <Header />
                <Box m={6}>
                    <Card
                        style={{
                            margin: '6%',
                            padding: '1%',
                            boxShadow: 'rgb(0 0 0 / 28%) 0px 4px 8px',
                            marginLeft: '10%',
                            width: '80%',
                        }}
                    >
                        <Container
                            style={{
                                maxWidth: 'none',
                                backgroundColor: 'white',
                                margin: '10px',
                            }}
                        >
                            <Box m={4}>
                                <Grid container justifyContent="space-between" alignItems="center">
                                    <Grid item>
                                        <h4 style={{ marginBottom: '1%' }}> MANAGER INDIVIDUAL VIEW</h4>
                                    </Grid>
                                </Grid>
                                <TableContainer component={Paper} style={{ marginTop: '20px' }}>
                                    <Table ref={tableRef}>
                                        <TableBody>{renderTableRows()}</TableBody>
                                    </Table>
                                </TableContainer>
                            </Box>
                        </Container>
                        <Grid item xs={12} container justifyContent="space-between" alignItems="center">
                            <Grid item xs={3}>
                                <span style={{ marginLeft: '28%' }}><FontAwesomeIcon icon={faUserCircle} /></span>
                            </Grid>
                            <Grid item xs={1}>
                                <span style={{ marginLeft: '-186%', font: 'message-box', fontWeight: 'bold', clear: 'both', display: 'inline-block', whiteSpace: 'nowrap' }}>Photo</span>
                            </Grid>
                            <Grid item xs={8}>
                                <span style={{ marginLeft: '1%', clear: 'both', display: 'inline-block', whiteSpace: 'nowrap', width: '100%' }}> {renderPhoto()}</span>
                            </Grid>
                        </Grid>
                        <div style={{ display: 'flex', justifyContent: 'flex-end' }} >
                            <Button style={{ marginRight: '1%' }} onClick={() => {
                                if (cmsId !== undefined && uid !== undefined) {
                                    handleCloseClick(cmsId, uid);
                                }
                            }}>
                                Close
                            </Button>
                            <Button variant="primary" style={{ marginRight: '1%' }} onClick={() => {
                                if (cmsId !== undefined && uid !== undefined) {
                                    handleUpdateClick(cmsId, uid);
                                }
                            }}>
                                Approve
                            </Button>
                        </div>
                    </Card>
                </Box>
            </Box>
            <div ref={componentRef}></div>
        </div>
    );
};


export default ManagerIndividualview;